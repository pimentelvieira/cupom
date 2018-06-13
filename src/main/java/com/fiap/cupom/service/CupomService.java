package com.fiap.cupom.service;

import com.fiap.cupom.Cupom;
import com.fiap.cupom.repository.CupomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CupomService {
    @Autowired
    private CupomRepository rep;

    public Cupom getCupom(Integer id) {
        return rep.findOne(id);
    }

}
