package com.ufg.trabalhoPOO.model;

import jakarta.persistence.*;
import java.util.List;

@Entity //Entidade do banco de dados
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // O banco gera o ID (1, 2, 3...)
    private int id;
    private String nome;

    @Column(unique = true) // não permite emails repetidos
    private String email;
    private String senha;
    private List<Avaliacao> avaliacoes;

    public Usuario(int id, String nome, String email, String senha){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public int getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }

    public String getEmail(){
        return email;
    }

    public String getSenha(){
        return senha;
    }

}
