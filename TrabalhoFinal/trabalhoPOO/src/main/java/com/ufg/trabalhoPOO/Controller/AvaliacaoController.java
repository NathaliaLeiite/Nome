package com.ufg.trabalhoPOO.Controller;

import com.ufg.trabalhoPOO.model.Avaliacao;
import com.ufg.trabalhoPOO.Repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/avaliacoes")

public class AvaliacaoController {

    @Autowired
    private AvaliacaoRepository repository;

    @GetMapping
    public List<Avaliacao> listarAvaliacoes() { // Listar todas as avaliações
        return repository.findAll();
    }

    @PostMapping
    public Avaliacao criarAvaliacao(@RequestBody Avaliacao avaliacao) { // Criar uma nova avaliação
        // Aqui o Spring vai tentar ligar o ID do usuário e o ISBN do livro automaticamente
        return repository.save(avaliacao);
    }

}
