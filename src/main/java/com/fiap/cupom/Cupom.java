package com.fiap.cupom;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Cupom implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Date data;
    @OneToMany(cascade=CascadeType.ALL, mappedBy="cupom", fetch = FetchType.EAGER)
    private List<Item> itens = new ArrayList<>();
    
    @ManyToOne
    private Cliente cliente;

    public Date getData() {
        return data;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Cliente getCliente() {
		return cliente;
	}
    
    public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
