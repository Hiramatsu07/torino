package com.example.torino.datos;

import java.util.ArrayList;

public class Chats {
    private int id;
    private Usuario mensajero;
    private String estado;
    public static ArrayList<Chats> chatsInicialesFicticios;
    static {
        chatsInicialesFicticios = new ArrayList<Chats>();

        chatsInicialesFicticios.add( new Chats(0,Usuario.buscarUsuarioId(0), "Conectado"));
        chatsInicialesFicticios.add( new Chats(1,Usuario.buscarUsuarioId(1), "Conectado"));
        chatsInicialesFicticios.add( new Chats(2,Usuario.buscarUsuarioId(3), "Conectado"));
    }


    public Chats(int id , Usuario mensajero , String estado){
        this.id = id;
        this.mensajero = mensajero;
        this.estado = estado;
    }


    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public Usuario getMensajero() { return mensajero; }

    public void setMensajero(Usuario mensajero) { this.mensajero = mensajero; }

    public String getEstado() { return estado; }

    public void setEstado(String estado) { this.estado = estado; }
}
