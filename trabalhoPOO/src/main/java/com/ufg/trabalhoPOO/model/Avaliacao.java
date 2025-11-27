package com.ufg.trabalhoPOO.model;

import jakarta.persistence.*;

@Entity // Entidade do banco de dados
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // O banco gera o ID 
    private Long id;

    // Quem avaliou?
    //Um usuário pode fazer muitas avaliações
    @ManyToOne
    @JoinColumn(name = "usuario_id") // Cria uma coluna usuario_id na tabela
    private Usuario usuario;

    // Qual livro?
    //Um livro pode ter muitas avaliações
    @ManyToOne
    @JoinColumn(name = "livro_id") // Cria uma coluna livro_id na tabela
    private Livro livro;

    private int nota;
    private String comentario;

    public Avaliacao() {
    
    }

    public Avaliacao(Usuario usuario, Livro livro, int nota, String comentario) {
        this.usuario = usuario;
        this.livro = livro;
        this.nota = nota;
        this.comentario = comentario;
    }

    public Long getId() { 
        return id; 
    }

    public void setId(Long id) { 
        this.id = id; 
    }

    public Usuario getUsuario() { 
        return usuario; 
    }

    public void setUsuario(Usuario usuario) { 
        this.usuario = usuario; 
    }

    public Livro getLivro() { 
        return livro; 
    }

    public void setLivro(Livro livro) { 
        this.livro = livro; 
    }

    public int getNota() { 
        return nota; 
    }

    public void setNota(int nota) { 
        this.nota = nota; 
    }

    public String getComentario() { 
        return comentario; 
    }

    public void setComentario(String comentario) { 
        this.comentario = comentario; 
    }
}