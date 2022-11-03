package com.example.torino.adaptadores;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.torino.R;
import com.example.torino.datos.Publicacion;
import com.example.torino.datos.Usuario;

import java.util.ArrayList;

public class FeedAdapter extends BaseAdapter {
    private final Activity actividad;
    private final ArrayList<Publicacion> lista;


    public FeedAdapter(Activity actividad, ArrayList<Publicacion> lista){
        this.actividad = actividad;
        this.lista = lista;
    }

    @Override
    public View getView(int posicion,View vista, ViewGroup padre){
        LayoutInflater inflater = actividad.getLayoutInflater();
        View view = inflater.inflate(R.layout.elementos_list_feed,null,true);

        Publicacion unaPublicacion = lista.get( posicion );


        int idRecursoImag = R.drawable.ch;

        ImageView fotoPerfil = view.findViewById(R.id.imageview1);
        if(posicion%3==0){
            idRecursoImag=R.drawable.ch;
        }else if(posicion%3==1){
            idRecursoImag=R.drawable.cha;
        }else if(posicion%3==2){
            idRecursoImag=R.drawable.chica;
        }
        fotoPerfil.setImageResource(idRecursoImag);
        return view;

        /*if(1==1) return;*/
        Usuario usuarioLogueado = getUsuarioLogueado();
        ArrayList<Publicacion> publicaciones = usuarioLogueado.getPublicaciones();

        Publicacion publicacionMostrada =publicaciones.get( posicion );
        Usuario publicador = publicacionMostrada.getPublicador();


        TextView nickname = view.findViewById( R.id.textview );
        nickname.setText(publicador.getNickname());

        TextView texto = view.findViewById(R.id.textview3);
        texto.setText(publicacionMostrada.getTexto());

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

}
