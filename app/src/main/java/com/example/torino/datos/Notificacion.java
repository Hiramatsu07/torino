package com.example.torino.datos;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Notificacion {
    private String fecha;
    private int useridseguidor;
    private String descripcion;



    public static ArrayList<Notificacion> notificaciones = new ArrayList<>();

    public Notificacion(int userid, String fecha, String descripcion) {
        this.useridseguidor = userid;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    static {
        notificaciones.add(new Notificacion(0,"05/20/2022", "Te siguió"));
        notificaciones.add(new Notificacion(1,"06/20/2022", "Le gusto tu publicacion"));
        notificaciones.add(new Notificacion(2,"07/20/2022", "Te siguió"));
    }

    public int getUseridseguidor() {
        return useridseguidor;
    }

    public void setUseridseguidor(int useridseguidor) {
        this.useridseguidor = useridseguidor;
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
