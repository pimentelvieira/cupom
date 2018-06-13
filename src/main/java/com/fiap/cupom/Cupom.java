package com.fiap.cupom;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;

@Entity
public class Cupom {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private Date data;
    private ArrayList<Produto> produtos = new ArrayList<>();

    public Date getData() {
        return data;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }
}
