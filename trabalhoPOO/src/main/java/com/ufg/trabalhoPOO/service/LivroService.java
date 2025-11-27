package com.ufg.trabalhoPOO.service;

import com.ufg.trabalhoPOO.model.Livro;
import com.ufg.trabalhoPOO.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public Livro salvarLivro(Livro livro){
        if(livro.getTitulo() == null || livro.getTitulo().isEmpty()){
            throw new RuntimeException("Título do livro é obrigatório.");
        }

        // Verifica se o livro com o mesmo ISBN já existe
        if(livroRepository.existsById(livro.getIsbn())){
            throw new RuntimeException("Livro com esse ISBN já existe.");
        }
        
        return livroRepository.save(livro);
    }

    public List<Livro> listarTodos() {
        return livroRepository.findAll();
    }

}
