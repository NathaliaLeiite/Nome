package com.ufg.trabalhoPOO.model;

public class Gostos {
    private String generoPreferido;
    private String livroAtual;

    public Gostos(String generoPreferido, String livroAtual){
        this.generoPreferido = generoPreferido;
        this.livroAtual = livroAtual;
    }

    public String getGeneroPreferido(){
        return generoPreferido;
    }

    public String getLivroAtual(){
        return livroAtual;
    }

}
