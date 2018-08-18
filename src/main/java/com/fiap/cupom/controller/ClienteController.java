package com.fiap.cupom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.cupom.Cliente;
import com.fiap.cupom.service.ClienteService;

@RestController
public class ClienteController {
    @Autowired
    private ClienteService service;
    @RequestMapping(value="/clientes", method=RequestMethod.GET)
    public ResponseEntity<Cliente> cliente() {
        return new ResponseEntity<>(service.getCliente(1), HttpStatus.OK);
    }
}
