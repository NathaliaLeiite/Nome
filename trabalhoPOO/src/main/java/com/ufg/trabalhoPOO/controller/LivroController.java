package com.ufg.trabalhoPOO.controller;

import com.ufg.trabalhoPOO.model.Livro;
import com.ufg.trabalhoPOO.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/livros") // O endereço do site será /livros
public class LivroController {

    @Autowired
    private LivroService service;

    // Listar todos os livros
    @GetMapping
    public List<Livro> listarLivros() {
        return service.listarTodos();
    }

    // Cadastrar um novo livro
    @PostMapping
    public ResponseEntity<?> cadastrarLivro(@RequestBody Livro livro) {
        try {
            Livro novoLivro = service.salvarLivro(livro);
            return ResponseEntity.ok(novoLivro);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
