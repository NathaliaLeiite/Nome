package com.ufg.trabalhoPOO.repository;

import com.ufg.trabalhoPOO.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);

    List<Usuario> findByGeneroPreferido(String generoPreferido);
}