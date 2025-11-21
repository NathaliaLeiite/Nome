package com.ufg.trabalhoPOO.model;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity // Entidade do banco de dados
public class Livro {

    @Id
    private String isbn;
    private String titulo;
    private String autor;
    private String genero;
    private int ano;

    //Um livro pode ter muitas avaliações
    @OneToMany(mappedBy = "livro")
    @JsonIgnore // Ignorar para evitar loop infinito
    private List<Avaliacao> avaliacoes;

    public Livro() {
    }

    public Livro(String isbn, String titulo, String autor, String genero, int ano){
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.ano = ano;
    }

    public String getIsbn(){
        return isbn;
    }

    public void setIsbn(String isbn){
        this.isbn = isbn;
    }

    public String getTitulo(){
        return titulo;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getAutor(){
        return autor;
    }

    public void setAutor(String autor){
        this.autor = autor;
    }

    public String getGenero(){
        return genero;
    }

    public void setGenero(String genero){
        this.genero = genero;
    }

    public int getAno(){
        return ano;
    }

    public void setAno(int ano){
        this.ano = ano;
    }
}
