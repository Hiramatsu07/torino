package com.example.torino.datos;

import java.util.ArrayList;

public class Usuario {
    private String nickname;
    private String nombreUsuario;
    private String mail;
    private String password;
    private String telefono;

    private static Usuario usuarioLogueado;
    private static ArrayList<Usuario> usuarios;

    static {
        usuarios = new ArrayList<>();
        usuarios.add( new Usuario("batman", "Bruce Wine", "batman@ciudadgotica.com", "batman", "0900123123"));
    }

    public Usuario(String nickname, String nombreApellido, String mail, String password,
                   String telefono) {
        this.nickname = nickname;
        this.nombreUsuario= nombreApellido;
        this.mail = mail;
        this.password = password;
        this.telefono = telefono;
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
}

