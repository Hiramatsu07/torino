package com.example.torino.datos;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Notificacion {
    private int id;
    private String fecha;
    private Usuario seguidor;
    private String descripcion;



    public static ArrayList<Notificacion> notificaciones = new ArrayList<>();


    public Notificacion(int id,Usuario user, String fecha, String descripcion) {
        this.id = id;
        this.seguidor = user;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    static {
        notificaciones.add(new Notificacion(0, Usuario.buscarUsuarioId(0),"05/20/2022", "Te siguió"));
        notificaciones.add(new Notificacion(1, Usuario.buscarUsuarioId(1),"06/20/2022", "Le gusto tu publicacion"));
        notificaciones.add(new Notificacion(2, Usuario.buscarUsuarioId(2),"07/20/2022", "Te siguió"));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static ArrayList<Notificacion> getNotificaciones() {
        return notificaciones;
    }

    public static void setNotificaciones(ArrayList<Notificacion> notificaciones) {
        Notificacion.notificaciones = notificaciones;
    }

    public Usuario getSeguidor() {
        return seguidor;
    }

    public void setSeguidor(Usuario userSeguidor) {
        this.seguidor = userSeguidor;
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
