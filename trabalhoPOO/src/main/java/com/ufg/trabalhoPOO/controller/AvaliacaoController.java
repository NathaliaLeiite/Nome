package com.ufg.trabalhoPOO.controller;

import com.ufg.trabalhoPOO.model.Avaliacao;
import com.ufg.trabalhoPOO.service.AvaliacaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService service;

    @GetMapping
    public List<Avaliacao> listarAvaliacoes() { // Listar todas as avaliações
        return service.listarTodas();
    }

    @PostMapping
    public ResponseEntity<?> criarAvaliacao(@RequestBody Avaliacao avaliacao) { // Criar uma nova avaliação
        try {
            Avaliacao novaAvaliacao = service.salvarAvaliacao(avaliacao);
            return ResponseEntity.ok(novaAvaliacao);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
