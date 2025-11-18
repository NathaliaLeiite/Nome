package com.ufg.trabalhoPOO.model;

import com.ufg.trabalhoPOO.model.Livro;

public class Avaliacao {
    private Livro livro;
    private int nota;
    private String comentario;

    public Avaliacao(Livro livro, int nota, String comentario){
        this.livro = livro;
        this.nota = nota;
        this.comentario = comentario;
    }

    public Livro getLivro(){
        return livro;
    }

    public int getNota(){
        return nota;
    }

    public String getComentario(){
        return comentario;
    }
}
