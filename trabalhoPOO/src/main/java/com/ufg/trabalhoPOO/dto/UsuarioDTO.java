package com.ufg.trabalhoPOO.dto;
// classe para transferir dados de Usuario sem expor sua senha
import com.ufg.trabalhoPOO.model.Usuario;

public class UsuarioDTO {

    private Long id;
    private String nome;
    private String email;
    private String generoPreferido;

    // informações que serão expostos
    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.generoPreferido = usuario.getGeneroPreferido();
    }

    public Long getId() { 
        return id; 
    }

    public String getNome() { 
        return nome; 
    }

    public String getEmail() { 
        return email; 
    }
    
    public String getGeneroPreferido() { 
        return generoPreferido; 
    }

}
