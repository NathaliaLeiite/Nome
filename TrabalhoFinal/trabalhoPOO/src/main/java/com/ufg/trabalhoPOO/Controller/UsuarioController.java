package com.ufg.trabalhoPOO.Controller;

import com.ufg.trabalhoPOO.model.Usuario;
import com.ufg.trabalhoPOO.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios") // O endereço do site será /usuarios
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    // 1. Buscar todos os usuários
    @GetMapping
    public List<Usuario> listarTodos() {
        return repository.findAll();
    }

    // 2. Criar um novo usuário
    @PostMapping
    public Usuario criarUsuario(@RequestBody Usuario usuario) {
        return repository.save(usuario);
    }
}
