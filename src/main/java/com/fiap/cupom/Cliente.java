package com.fiap.cupom;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;

@Entity
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String cpf;
    private String rg;
    private String nome;
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="cliente", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Cupom> cupons;

    public int getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    public String getNome() {
        return nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public List<Cupom> getCupons() {
		return cupons;
	}
    
    public void setCupons(List<Cupom> cupons) {
		this.cupons = cupons;
	}
}
