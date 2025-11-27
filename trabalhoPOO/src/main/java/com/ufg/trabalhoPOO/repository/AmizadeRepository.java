package com.ufg.trabalhoPOO.repository;

import com.ufg.trabalhoPOO.model.Amizade;
import com.ufg.trabalhoPOO.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AmizadeRepository extends JpaRepository<Amizade, Long> {
    // Busca amizades onde o usuário1 é "tal pessoa"
    List<Amizade> findByUsuario1(Usuario usuario1);
}
