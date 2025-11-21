package com.ufg.trabalhoPOO.Controller;

import com.ufg.trabalhoPOO.model.Livro;
import com.ufg.trabalhoPOO.Repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/livros") // O endereço do site será /livros
public class LivroController {

    @Autowired
    private LivroRepository repository;

    // Listar todos os livros
    @GetMapping
    public List<Livro> listarLivros() {
        return repository.findAll();
    }

    // Cadastrar um novo livro
    @PostMapping
    public Livro cadastrarLivro(@RequestBody Livro livro) {
        return repository.save(livro);
    }
}
