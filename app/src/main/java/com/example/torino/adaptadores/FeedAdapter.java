package com.example.torino.adaptadores;

import android.app.Activity;
import android.util.Log;
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
    String TAG ="FeedAdapter";

    public FeedAdapter(Activity actividad, ArrayList<Publicacion> lista){
        this.actividad = actividad;
        this.lista = lista;
    }

    @Override
    public View getView(int posicion,View vista, ViewGroup padre){
        LayoutInflater inflater = actividad.getLayoutInflater();
        View view = inflater.inflate(R.layout.elementos_list_feed,null,true);


        Publicacion publicacionMostrada =lista.get( posicion );
        Usuario publicador = publicacionMostrada.getPublicador();

        TextView nickname = view.findViewById( R.id.textview );
        nickname.setText(publicador.getNickname());

        int idRecursoImag = 0;
        int idUs = publicador.getId();


        ImageView fotoPerfil = view.findViewById(R.id.imageview1);
        if(idUs==0){
            idRecursoImag=R.drawable.ch;
        }else if(idUs==1){
            idRecursoImag=R.drawable.cha;
        }else if(idUs==2){
            idRecursoImag=R.drawable.chica;
        }else{
            idRecursoImag=R.drawable.foto_perfil;
        }
        fotoPerfil.setImageResource(idRecursoImag);




        TextView texto = view.findViewById(R.id.textview3);
        texto.setText(publicacionMostrada.getTexto());
        Log.i(TAG,"nickname"+publicador.getNickname());
        return view;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int arg0) {
        if(lista != null){
            return lista.get(arg0);
        }
        return null;
    }

    @Override
    public long getItemId(int arg0) {
        Publicacion unaPublicacion = lista.get(arg0);
        return unaPublicacion.getId();
    }

}
