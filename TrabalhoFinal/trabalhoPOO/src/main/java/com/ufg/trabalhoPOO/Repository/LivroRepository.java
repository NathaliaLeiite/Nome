package com.ufg.trabalhoPOO.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ufg.trabalhoPOO.model.Livro;
import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, String> {
    List<Livro> findByTituloContaining(String titulo);
}
