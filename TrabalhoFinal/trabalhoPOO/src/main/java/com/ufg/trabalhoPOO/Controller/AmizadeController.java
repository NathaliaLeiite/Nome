package com.ufg.trabalhoPOO.Controller;

import com.ufg.trabalhoPOO.model.Amizade;
import com.ufg.trabalhoPOO.model.Usuario;
import com.ufg.trabalhoPOO.Repository.AmizadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/amizades")
public class AmizadeController {

    @Autowired
    private AmizadeRepository repository;

    // Listar todas as amizades
    @GetMapping
    public List<Amizade> listarAmizades() {
        return repository.findAll();
    }

    // Criar uma nova amizade
    @PostMapping
    public Amizade adicionarAmigo(@RequestBody Amizade amizade) {
        if (amizade.getStatus() == null) {
            amizade.setStatus("PENDENTE");
        }
        return repository.save(amizade);
    }
}
