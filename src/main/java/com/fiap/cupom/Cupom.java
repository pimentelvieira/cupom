package com.fiap.cupom;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Cupom implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private Date data;
    @OneToMany(cascade=CascadeType.ALL, mappedBy="cupom", fetch = FetchType.EAGER)
    private List<Item> itens = new ArrayList<>();

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

}
