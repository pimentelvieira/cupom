package com.fiap.cupom.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.cupom.Cupom;
import com.fiap.cupom.Item;
import com.fiap.cupom.service.CupomService;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@RestController
public class CupomController {
    @Autowired
    private CupomService service;
    @RequestMapping(value="/cupons", method=RequestMethod.GET)
    public ResponseEntity<Cupom> getCupom() throws JMSException {
    	Cupom cupom = service.getCupom(leIdFilaCupom());
    	geraPDF(cupom);
        return new ResponseEntity<>(cupom, HttpStatus.OK);
    }
    
    @RequestMapping(value="/cupons/publica", method=RequestMethod.GET)
    public ResponseEntity<String> publica() throws JMSException {
    	ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
		Connection connection = connectionFactory.createConnection();
		connection.start();

		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		Destination destination = session.createQueue("cupom");

		MessageProducer producer = session.createProducer(destination);

		TextMessage message = session.createTextMessage("1");

		producer.send(message);
		System.out.println("Sentage '" + message.getText() + "'");

		connection.close();
        return new ResponseEntity<>("Publicado com sucesso na fila cupom", HttpStatus.OK);
    }
    
    private void geraPDF(Cupom cupom) {
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    	Document document = new Document();
    	
    	File file = new File( "d:\\teste\\PDF_Teste.pdf" );
    	if(file.exists()) {
    		file.delete();
    	}
    	
    	double total = 0.0;
    	
    	for(int i =0; i < cupom.getItens().size(); i++) {
    		total = total + (cupom.getItens().get(i).getQuantidade() * cupom.getItens().get(i).getProduto().getValor());
    	}
    		
    	
		try 
		{
			PdfWriter writer =  PdfWriter.getInstance(document, new FileOutputStream("d:\\teste\\PDF_Teste.pdf"));
			document.open();

			// adicionando um paragrafo no documento
			document.add(new Paragraph("FIAP Roupas"));
			document.add(new Paragraph("Avenida Lins de Vasconcelos"));
			document.add(new Paragraph("São Paulo - SP"));
			document.add(new Paragraph("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"));
			document.add(new Paragraph("CPF: " + cupom.getCliente().getCpf()));
			document.add(new Paragraph("Data: " + sdf.format(cupom.getData())));
			document.add(new Paragraph("Cupom Fiscal"));
			document.add(new Paragraph("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n"));

			// adicionando um paragrafo no documento
			document.add(new Paragraph("-------------------------------------------------------------------------"));
			document.add(new Paragraph("Total R$: 													" + total));
			document.add(new Paragraph("																		"));
			document.add(new Paragraph("																		"));
			document.add(new Paragraph("ITEM 	CÓDIGO 		DESCRICAO 		QTD. 		VL"));
			document.add(new Paragraph("-------------------------------------------------------------------------"));
	    	for(int i =0; i < cupom.getItens().size(); i++) {
	    		Item item = cupom.getItens().get(i);
	    		
	    		document.add(new Paragraph(i + 1 + " " + item.getProduto().getId() + " " + item.getProduto().getDescricao() + " " + item.getQuantidade() + " " + item.getProduto().getValor()));			
	    	}
			document.addSubject("Gerando PDF em Java");
			document.addKeywords("www.fiap.com.br");
			document.addCreator("by 30SCJ");
			document.addAuthor("William Pimentel e Everton Melo");
			
		} 
		catch (  DocumentException de ) 
		{
			System.err.println(de.getMessage());
		} 
		catch ( IOException ioe ) 
		{
			System.err.println(ioe.getMessage());
		}
		document.close();
    }
    
    private Integer leIdFilaCupom() throws JMSException {
    	ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
		Connection connection = connectionFactory.createConnection();
		connection.start();

		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		Destination destination = session.createQueue("cupom");

		MessageConsumer consumer = session.createConsumer(destination);

		Message message = consumer.receive();
		TextMessage textMessage = null;

		if (message instanceof TextMessage) {
			textMessage = (TextMessage) message;
			System.out.println("Receivedage '" + textMessage.getText() + "'");
		}
		connection.close();
		
		return Integer.parseInt(textMessage.getText());
    }
}
