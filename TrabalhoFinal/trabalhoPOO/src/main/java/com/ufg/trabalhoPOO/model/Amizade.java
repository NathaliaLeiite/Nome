package com.ufg.trabalhoPOO.model;

public class Amizade {
    private Usuario usuario1;
    private Usuario usuario2;
    private String status;

    public Amizade(Usuario usuario1, Usuario usuario2, String status){
        this.usuario1 = usuario1;
        this.usuario2 = usuario2;
        this.status = status;
    }

    public Usuario getUsuario1(){
        return usuario1;
    }

    public Usuario getUsuario2(){
        return usuario2;
    }

    public String getStatus(){
        return status;
    }
}
