package com.ufg.trabalhoPOO.controller;

import com.ufg.trabalhoPOO.model.Amizade;
import com.ufg.trabalhoPOO.service.AmizadeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/amizades")
public class AmizadeController {

    @Autowired
    private AmizadeService service;

    // Listar todas as amizades
    @GetMapping
    public List<Amizade> listarAmizades() {
        return service.listarTodas();
    }

    // Criar uma nova amizade
    @PostMapping
    public ResponseEntity<?> adicionarAmigo(@RequestBody Amizade amizade) {
        try {
            Amizade novaAmizade = service.solicitarAmizade(amizade);
            return ResponseEntity.ok(novaAmizade);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> responderSolicitacao(
            @PathVariable Long id, 
            @RequestParam String status) {
        try {
            Amizade amizadeAtualizada = service.responderAmizade(id, status);
            return ResponseEntity.ok(amizadeAtualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
