package com.ufg.trabalhoPOO.repository;

import com.ufg.trabalhoPOO.model.Avaliacao;
import com.ufg.trabalhoPOO.model.Livro;
import com.ufg.trabalhoPOO.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
    // Busca as avaliações de um livro específico
    List<Avaliacao> findByLivro(Livro livro);
    
    // Busca todas as avaliações de um usuário
    List<Avaliacao> findByUsuario(Usuario usuario);
}