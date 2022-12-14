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
    String TAG ="ChatAdapter";

    public ChatAdapter(Activity actividad, ArrayList<Chats> lista){
        this.actividad = actividad;
        this.lista = lista;
    }

    @Override
    public View getView(int posicion,View vista, ViewGroup padre){
        LayoutInflater inflater = actividad.getLayoutInflater();
        View view = inflater.inflate(R.layout.elementos_list_chat,null,true);


        Chats chatsMostrada = lista.get( posicion );
        Usuario mensajero = chatsMostrada.getMensajero();

        TextView nickname = view.findViewById( R.id.nombre_usuario );
        Log.i(TAG, mensajero.getNickname());
        nickname.setText(mensajero.getNickname());

        int idRecursoImag = 0;
        int idUs = mensajero.getId();


        ImageView fotoPerfil = view.findViewById(R.id.imageview1);
        if(idUs==0){
            idRecursoImag=R.drawable.ch;
        }else if(idUs==1){
            idRecursoImag=R.drawable.foto_perfil;
        }else if(idUs==2){
            idRecursoImag=R.drawable.chica;
        }else{
            idRecursoImag=R.drawable.foto_perfil;
        }
        fotoPerfil.setImageResource(idRecursoImag);




        TextView texto = view.findViewById(R.id.mensaje_del_usuario);
        texto.setText(chatsMostrada.getEstado());
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
