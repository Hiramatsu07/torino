package com.example.torino.datos;

import java.util.ArrayList;

public class Chats {
    private int id;
    private Usuario mensajero;
    private String texto;
    public static ArrayList<Chats> chatsInicialesFicticios;
    static {
        chatsInicialesFicticios = new ArrayList<Chats>();

        chatsInicialesFicticios.add( new Chats(0,Usuario.buscarUsuarioId(0), "Te mande algo"));
        chatsInicialesFicticios.add( new Chats(1,Usuario.buscarUsuarioId(1), "Quete"));
        chatsInicialesFicticios.add( new Chats(2,Usuario.buscarUsuarioId(3), "porque soy intolerante al gluten"));
    }


    public Chats(int id , Usuario mensajero , String texto){
        this.id = id;
        this.mensajero = mensajero;
        this.texto = texto;
    }




    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public Usuario getMensajero() { return mensajero; }

    public void setMensajero(Usuario mensajero) { this.mensajero = mensajero; }

    public String getTexto() { return texto; }

    public void setTexto(String texto) { this.texto = texto; }
}
