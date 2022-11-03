package com.example.torino.datos;

import java.util.ArrayList;

public class Usuario {
    private final String nickname;
    private String mail;
    private String password;
    private int id;

    public ArrayList<Publicacion> publicaciones = new ArrayList<>();

    public static Usuario usuarioLogueado;
    public static final ArrayList<Usuario> usuarios;

    static {
        usuarios = new ArrayList<>();
        usuarios.add( new Usuario("Artur",  "artur", "1", 0));
        usuarios.add( new Usuario("Martina",  "martina", "1", 1));
        usuarios.add( new Usuario("Lara", "lara", "1",2));
    }

    public Usuario(String nickname,  String mail, String password,
                    int id) {
        this.nickname = nickname;
        this.mail = mail;
        this.password = password;
        this.id = id;
    }
    public static boolean comprobarCredenciales(String email, String password) {

        for( Usuario usuario : usuarios) {
            if ( email.equals(usuario.getMail()) && password.equals(usuario.getPassword())){
                return true;
            }else{
                if ( email.equals("") && password.equals("")) {
                    return false;
                }
            }
        }
        return false;
    }
    public static void setUsuarioLogueado(Usuario usuario) {
        usuarioLogueado = usuario;
    }

    public static Usuario getUsuarioLogueado() {
        return usuarioLogueado;
    }

    public static Usuario getUsuario(String email ) {
        for( Usuario usuario : usuarios) {
            if ( email.equals(usuario.getMail()) ){
                return usuario;
            }
        }
        return null;
    }
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Publicacion> getPublicaciones() {
        return publicaciones;
    }

    public void setPublicaciones(ArrayList<Publicacion> publicaciones) {
        this.publicaciones = publicaciones;
    }

    public void agregarPublicacion (Publicacion unaPublicacion){ publicaciones.add( unaPublicacion );}
}

