package com.fiap.cupom.controller;

import com.fiap.cupom.Cupom;
import com.fiap.cupom.service.CupomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CupomController {
    @Autowired
    private CupomService service;
    @RequestMapping("/cupom")
    public ResponseEntity<Cupom> cupom() {
        return new ResponseEntity<>(service.getCupom(1), HttpStatus.OK);
    }
}
