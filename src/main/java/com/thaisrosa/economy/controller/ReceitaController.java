package com.thaisrosa.economy.controller;

import com.thaisrosa.economy.domain.Transacao;
import com.thaisrosa.economy.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/receita")
public class ReceitaController {

    @Autowired
    private TransacaoService transacaoService;

    @GetMapping
    @ResponseBody
    public List<Transacao> getAll() {
        return transacaoService.getAllReceita();
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Transacao> create(@RequestBody Transacao transacao) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(transacaoService.createReceita(transacao));
    }

    @DeleteMapping("/id")
    @ResponseBody
    public void delete(@PathVariable Long id) {
        transacaoService.delete(id);
    }
}
