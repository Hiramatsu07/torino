package com.example.torino.adaptadores;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.torino.R;
import com.example.torino.datos.Notificacion;
import com.example.torino.datos.Usuario;

import java.util.ArrayList;

public class NotificacionAdaptador extends BaseAdapter{

    private final Activity actividad;
    private final ArrayList<Notificacion> lista;

    public NotificacionAdaptador(Activity actividad, ArrayList<Notificacion> lista) {
        super();
        this.actividad = actividad;
        this.lista = lista;
    }


    @Override
    public View getView(int posicion, View vista, ViewGroup padre) {
       LayoutInflater inflater = actividad.getLayoutInflater();
       View view = inflater.inflate(R.layout.elementos_notificacion, null, true);

       Notificacion notificacion = lista.get(posicion);
       Usuario seguidor = notificacion.getSeguidor();
       TextView nickname = view.findViewById(R.id.nickname);
       nickname.setText(seguidor.getNickname());

       TextView descripcion = view.findViewById(R.id.descripcion);
       descripcion.setText(notificacion.getDescripcion());

       int idUs = seguidor.getId();
       int idRecursoImag = 0;

        ImageView fotoPerfil = view.findViewById(R.id.imageView1);
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
        Notificacion unaNotificacion = lista.get(arg0);
        return unaNotificacion.getId();
    }


}

