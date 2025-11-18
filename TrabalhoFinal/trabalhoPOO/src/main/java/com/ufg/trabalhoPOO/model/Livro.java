package com.ufg.trabalhoPOO.model;

public class Livro {
    private int isbn;
    private String titulo;
    private String autor;
    private String genero;
    private int ano;

    public Livro(int isbn, String titulo, String autor, String genero, int ano){
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.ano = ano;
    }

    public int getIsbn(){
        return isbn;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getAutor(){
        return autor;
    }

    public String getGenero(){
        return genero;
    }

    public int getAno(){
        return ano;
    }
}
