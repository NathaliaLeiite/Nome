package com.ufg.trabalhoPOO.service;

import com.ufg.trabalhoPOO.model.Amizade;
import com.ufg.trabalhoPOO.repository.AmizadeRepository;
import com.ufg.trabalhoPOO.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AmizadeService {

    @Autowired
    private AmizadeRepository amizadeRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Amizade solicitarAmizade(Amizade amizade){

        //1. verificar se usuários existem
        Long id1 = amizade.getUsuario1().getId();
        Long id2 = amizade.getUsuario2().getId();

        if(!usuarioRepository.existsById(id1) || !usuarioRepository.existsById(id2)){
            throw new IllegalArgumentException("Um ou ambos os usuários não existem.");
        }

        //2. verifica se o usuário não está tentando adicionar ele mesmo
        if(id1.equals(id2)){
            throw new IllegalArgumentException("Um usuário não pode adicionar a si mesmo como amigo.");
        }

        amizade.setStatus("PENDENTE");

        return amizadeRepository.save(amizade);
    }

    public List<Amizade> listarTodas() {
        return amizadeRepository.findAll();
    }

    public Amizade responderAmizade(Long id, String status) {
        Amizade amizade = amizadeRepository.findById(id).orElseThrow(() -> new RuntimeException("Solicitação de amizade não encontrada."));

        if (!status.equals("ACEITO") && !status.equals("RECUSADO")) {
            throw new IllegalArgumentException("Status inválido. Use 'ACEITO' ou 'RECUSADO'.");
        }

        amizade.setStatus(status);
        return amizadeRepository.save(amizade);
    }
}
