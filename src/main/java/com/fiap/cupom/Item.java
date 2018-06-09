package com.fiap.cupom;

import javax.persistence.Entity;
import javax.transaction.Transactional;

@Entity
@Transactional
public class Item {
    private Produto produto;
    private int quantidade;

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
