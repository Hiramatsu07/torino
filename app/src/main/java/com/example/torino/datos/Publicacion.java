package com.example.torino.datos;

import java.util.ArrayList;

public class Publicacion {
    private int id;
    private Usuario publicador;
    private String texto;
    private int like;
    private int dislike;
    public static ArrayList<Publicacion> publicacionesInicialesFicticias;
    static {
        publicacionesInicialesFicticias = new ArrayList<Publicacion>();

        publicacionesInicialesFicticias.add( new Publicacion(0,Usuario.buscarUsuarioId(1), "Una publicacion x", 8, 3));
        publicacionesInicialesFicticias.add( new Publicacion(1,Usuario.buscarUsuarioId(2), "Me siento re diva", 8, 3));
        publicacionesInicialesFicticias.add( new Publicacion(2,Usuario.buscarUsuarioId(0), "Soy Batman", 8, 3));
    }


    public Publicacion( int id , Usuario publicador , String texto , int like , int dislike ){
        this.id = id;
        this.publicador = publicador;
        this.texto = texto;
        this.like = like;
        this.dislike = dislike;
    }




    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public Usuario getPublicador() { return publicador; }

    public void setPublicador(Usuario publicador) { this.publicador = publicador; }

    public String getTexto() { return texto; }

    public void setTexto(String texto) { this.texto = texto; }

    public int getLike() { return like; }

    public void setLike(int like) { this.like = like; }

    public int getDislike() { return dislike; }

    public void setDislike(int dislike) { this.dislike = dislike; }
}
