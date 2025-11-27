package com.ufg.trabalhoPOO.service;

import com.ufg.trabalhoPOO.model.Avaliacao;
import com.ufg.trabalhoPOO.repository.AvaliacaoRepository;
import com.ufg.trabalhoPOO.repository.LivroRepository;
import com.ufg.trabalhoPOO.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired 
    private LivroRepository livroRepository;

    public Avaliacao salvarAvaliacao(Avaliacao avaliacao){
        if (avaliacao.getNota() < 0 || avaliacao.getNota() > 5) {
            throw new RuntimeException("Erro: A nota deve ser entre 0 e 5!");
        }

        Long usuarioId = avaliacao.getUsuario().getId();
        if (!usuarioRepository.existsById(usuarioId)) {
            throw new RuntimeException("Erro: Usuário com ID " + usuarioId + " não encontrado.");
        }

        String livroIsbn = avaliacao.getLivro().getIsbn();
        if (!livroRepository.existsById(livroIsbn)) {
            throw new RuntimeException("Erro: Livro com ISBN " + livroIsbn + " não encontrado.");
        }

        return avaliacaoRepository.save(avaliacao);
    }

    public java.util.List<Avaliacao> listarTodas() {
        return avaliacaoRepository.findAll();
    }

}
