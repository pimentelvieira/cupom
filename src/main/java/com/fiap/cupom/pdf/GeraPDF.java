package com.fiap.cupom.pdf;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class GeraPDF {

	public static void main(String[] args) {
		Document document = new Document();
		try 
		{
			PdfWriter writer =  PdfWriter.getInstance(document, new FileOutputStream("d:\\teste\\PDF_Teste.pdf"));
			document.open();

			// adicionando um paragrafo no documento
			document.add(new Paragraph("FIAP Roupas"));
			document.add(new Paragraph("Avenida Lins de Vasconcelos"));
			document.add(new Paragraph("São Paulo - SP"));
			document.add(new Paragraph("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"));
			document.add(new Paragraph("CPF: " + "6546546546"));
			document.add(new Paragraph("Data: " + "10/10/2018"));
			document.add(new Paragraph("Cupom Fiscal"));
			document.add(new Paragraph("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n"));

			
			
			document.addSubject("Gerando PDF em Java");
			document.addKeywords("www.fiap.com.br");
			document.addCreator("by 29SCJ");
			document.addAuthor("Marcos Macedo");
			
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
}
