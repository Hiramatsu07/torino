package com.example.torino.datos;

import android.util.Log;

import java.util.ArrayList;

public class Usuario {
    private String nickname;
    private String mail;
    private String password;
    private int id;

    private static Usuario usuarioLogueado;
    public static final ArrayList<Usuario> usuarios;
    public ArrayList<Publicacion> publicaciones;
    public ArrayList<Usuario> amigos;

    String TAG = "Usuario";

    static {
        usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Batman", "h", "h",0));
        usuarios.add(new Usuario("Artur","artur","1",1));
        usuarios.add(new Usuario("Pilar","pili","1",2));
        usuarios.add(new Usuario("Milagros","mili","1",3));

        usuarios.get(1).getAmigos().add(usuarios.get(0));
        usuarios.get(0).getPublicaciones().add(new Publicacion(0,Usuario.buscarUsuarioId(0), "Una publicacion x", 8, 3));
        usuarios.get(1).getPublicaciones().add(new Publicacion(1,Usuario.buscarUsuarioId(1), "Una publicacion x", 8, 3));

    }

    public Usuario(String nickname, String mail, String password, int id) {
        this.nickname = nickname;
        this.mail = mail;
        this.password = password;
        this.id = id;
        this.publicaciones = new ArrayList<>();
        this.amigos = new ArrayList<>();
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
        Log.i("setUsuarioLogueado", "Usuario logueado: " + usuarioLogueado);
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
    public static int getIndexUsuario(Usuario usuarioLogueado){
        int index = 0;
        for (Usuario usuario : usuarios) {
            if (usuarioLogueado.getMail().equals(usuario.getMail())) {
                return index;
            }
            index ++;
        }
        return -1;
    }

    public static Usuario usuarioExiste(String email){
        for (Usuario usuario : usuarios) {
            if (email.equals(usuario.getMail())){
                return usuario;
            }
        }
        return null;
    }
    public static Usuario buscarUsuarioId(int id){
        for(Usuario unUsuario : usuarios){
            if(unUsuario.getId()==id){
                return unUsuario;
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


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public  ArrayList<Publicacion> getFeed(){
        ArrayList<Publicacion> publicacionesFeed = new ArrayList<>();
        for(Usuario unAmigo : amigos){
            for (Publicacion unaPublicacion : unAmigo.publicaciones){
                publicacionesFeed.add(unaPublicacion);
                Log.i(TAG,"Texto de publicacion "+unaPublicacion.getTexto());
            }
        }

        return publicacionesFeed;
    }

    public ArrayList<Usuario> getAmigos() {
        return amigos;
    }

    public void setAmigos(ArrayList<Usuario> amigos) {
        this.amigos = amigos;
    }

    public ArrayList<Publicacion> getPublicaciones() {
        return publicaciones;
    }

    public void setPublicaciones(ArrayList<Publicacion> publicaciones) {
        this.publicaciones = publicaciones;
    }
    public void setNickname(String nickname){this.nickname = nickname; }

}

