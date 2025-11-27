package com.ufg.trabalhoPOO.controller;

import com.ufg.trabalhoPOO.model.Usuario;
import com.ufg.trabalhoPOO.dto.UsuarioDTO;
import com.ufg.trabalhoPOO.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/usuarios") // O endereço do site
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    // 1. Buscar todos os usuários
    @GetMapping
    public List<UsuarioDTO> listarTodos() {
        return service.buscarTodos();
    }

    // 2. Criar um novo usuário
    @PostMapping
    public ResponseEntity<?> criarUsuario(@RequestBody Usuario usuario) {
        try {
            UsuarioDTO novoUsuario = service.salvarUsuario(usuario);
            return ResponseEntity.ok(novoUsuario);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/comunidade")
    public ResponseEntity<?> buscarPorGosto(@RequestParam String genero) {
        try {
            List<UsuarioDTO> comunidade = service.filtrarPorGenero(genero);
            return ResponseEntity.ok(comunidade);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
