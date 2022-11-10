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
import com.example.torino.datos.Chats;
import com.example.torino.datos.Usuario;

import java.util.ArrayList;

public class ChatAdapter extends BaseAdapter {
    private final Activity actividad;
    private final ArrayList<Chats> lista;
    String TAG ="FeedAdapter";

    public ChatAdapter(Activity actividad, ArrayList<Chats> lista){
        this.actividad = actividad;
        this.lista = lista;
    }

    @Override
    public View getView(int posicion,View vista, ViewGroup padre){
        LayoutInflater inflater = actividad.getLayoutInflater();
        View view = inflater.inflate(R.layout.elementos_list_chat,null,true);


        Chats chatsMostrada =lista.get( posicion );
        Usuario mensajero = chatsMostrada.getMensajero();

        TextView nickname = view.findViewById( R.id.textview );
        nickname.setText(mensajero.getNickname());

        int idRecursoImag = 0;
        int idUs = mensajero.getId();


        ImageView fotoPerfil = view.findViewById(R.id.imageview1);
        if(idUs==1){
            idRecursoImag=R.drawable.ch;
        }else if(idUs==2){
            idRecursoImag=R.drawable.cha;
        }else if(idUs==3){
            idRecursoImag=R.drawable.chica;
        }else if(idUs==0 && idUs>3){
            idRecursoImag=R.drawable.usuario;
        }
        fotoPerfil.setImageResource(idRecursoImag);




        TextView texto = view.findViewById(R.id.textview3);
        texto.setText(chatsMostrada.getTexto());
        Log.i(TAG,"nickname"+mensajero.getNickname());
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
        Chats unChats = lista.get(arg0);
        return unChats.getId();
    }

}
