package com.ufg.trabalhoPOO.service;

import com.ufg.trabalhoPOO.model.Usuario;
import com.ufg.trabalhoPOO.dto.UsuarioDTO;
import com.ufg.trabalhoPOO.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioDTO salvarUsuario(Usuario usuario){  // verifica se o usuário forneceu nome (obrigatório)
        if (usuario.getNome() == null || usuario.getNome().isEmpty()){
            throw new RuntimeException("Nome do usuário é obrigatório.");
        }

        if (usuario.getSenha() == null || usuario.getSenha().isEmpty() || usuario.getSenha().length() < 3){
            throw new RuntimeException("Senha do usuário é obrigatória e deve ter pelo menos 3 caracteres.");
        }

        Usuario existente = usuarioRepository.findByEmail(usuario.getEmail());
        if(existente != null){
            throw new RuntimeException("Esse email já foi cadastrado! Use outro email.");
        }

        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        return new UsuarioDTO(usuarioSalvo);
    }

    public List<UsuarioDTO> buscarTodos() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        // Converção de Usuario em UsuarioDTO (sem a senha)
        return usuarios.stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }

    // buscar comunidade por gênero preferido
    public List<UsuarioDTO> filtrarPorGenero(String genero) {
        if (genero == null || genero.trim().isEmpty()) {
            throw new RuntimeException("Erro: O gênero para pesquisa não pode ser vazio.");
        }
        List<Usuario> usuarios = usuarioRepository.findByGeneroPreferido(genero);
        return usuarios.stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }
}

// regras: exigir senha, não permitir email repetido
