package com.fiap.cupom;

import javax.persistence.Entity;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Transactional
public class Cupom {
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
