package com.fiap.cupom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.cupom.Cliente;
import com.fiap.cupom.repository.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository rep;

    public Cliente getCliente(Integer id) {
        return rep.findOne(id);
    }

}
