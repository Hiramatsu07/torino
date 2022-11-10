package com.example.torino.datos;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Notificacion {
    private String fecha;
    private int userid;
    private String descripcion;
    private Usuario seguidor;



    public static ArrayList<Notificacion> notificaciones = new ArrayList<>();

    public Notificacion(int userid, Usuario user, String fecha, String descripcion) {
        this.userid = userid;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.seguidor = user;
    }

    static {
        notificaciones.add(new Notificacion(0,"05/20/2022", "Te siguió"));
        notificaciones.add(new Notificacion(1,"06/20/2022", "Le gusto tu publicacion"));
        notificaciones.add(new Notificacion(2,"07/20/2022", "Te siguió"));
    }

    public int getUseridseguidor() {
        return userid;
    }

    public void setUseridseguidor(int userid) {
        this.userid = userid;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
