package com.example.torino.datos;

import java.util.ArrayList;

public class Usuario {
    private String nickname;
    private String mail;
    private String password;

    private static Usuario usuarioLogueado;
    public static final ArrayList<Usuario> usuarios;

    static {
        usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Batman", "h", "h"));
    }

    public Usuario(String nickname, String mail, String password) {
        this.nickname = nickname;
        this.mail = mail;
        this.password = password;
    }

    public static boolean comprobarCredenciales(String email, String password) {

        for (Usuario usuario : usuarios) {
            if (email.equals(usuario.getMail()) && password.equals(usuario.getPassword())) {
                return true;
            } else {
                if (email.equals("") && password.equals("")) {
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


    public static Usuario getUsuario(String email) {
        for (Usuario usuario : usuarios) {
            if (email.equals(usuario.getMail())) {
                return usuario;
            }
        }
        return null;
    }

    public static boolean existeCuenta(String email, String nickname) {
        for (Usuario usuario : usuarios) {
            if (email.equals(usuario.getMail()) || nickname.equals(usuario.getNickname())) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }


    public static Usuario usuarioExiste(String email){
        for (Usuario usuario : usuarios) {
            if (email.equals(usuario.getMail())){
                return usuario;
            } else {
                return null;
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

    public void setNickname(){this.nickname = nickname; }
}

