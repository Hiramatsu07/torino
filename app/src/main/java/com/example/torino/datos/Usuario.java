package com.example.torino.datos;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.torino.R;
import com.example.torino.adaptadores.UsuarioAdapter;

import java.util.ArrayList;
import java.util.List;

public class Usuario extends AppCompatActivity {
    private String nickname;
    private String mail;
    private String password;
    private int id;

    private static Usuario usuarioLogueado;
    //public static final ArrayList<Usuario> usuarios;
    public ArrayList<Publicacion> publicaciones;
    public ArrayList<Usuario> amigos;

    private RecyclerView recyclerView;
    private UsuarioAdapter lista;
    private List<Usuario> usuarioList;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_buscar_usuarios);


        recyclerView = findViewById(R.id.search_bar);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        usuarioList = new ArrayList<>();
    }


    String TAG = "Usuario";

    public static ArrayList<Usuario> usuarios = new ArrayList<>();

    static {
        usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Batman", "h", "h",0));
        usuarios.add(new Usuario("Artur","artur","1",1));
        usuarios.add(new Usuario("Pilar","pili","1",2));
        usuarios.add(new Usuario("Milagros","mili","1",3));
        usuarios.add(new Usuario("Mariana", "mari", "h",4));
        usuarios.add(new Usuario("Belen","belu","1",5));
        usuarios.add(new Usuario("Jimena","jime","1",6));
        usuarios.add(new Usuario("Daniela","dani","1",7));
        usuarios.add(new Usuario("Ignacio", "inaki", "h",8));
        usuarios.add(new Usuario("Jorge","negro","1",9));


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

    public static boolean setNuevoSeguido(String nickname){
        String TAG="Usuarios ciclados";
            for (Usuario amigo : usuarioLogueado.amigos){
                Log.i(TAG, "amigo: "+amigo.getNickname());
                if(amigo.getNickname().equals(nickname)){
                    return false;
                }
            }
        for (Usuario usuario : usuarios){
            if(usuario.getNickname().equals(nickname)){
                usuarioLogueado.amigos.add(usuario);
                return true;
            }
        }
        return false;
    }
    public static ArrayList verNoAmigos(){
        ArrayList <Usuario> noAmigos = new ArrayList<>();
        for (Usuario usuarioAmigo : usuarioLogueado.amigos) {
            int idUs = usuarioAmigo.getId();
                for (Usuario usuario : usuarios) {
                    if (usuario.getId()!=idUs) {
                        noAmigos.add(usuario);
                    }
                }
        }
        return noAmigos;
    }
}


