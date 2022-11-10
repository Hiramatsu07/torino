package com.example.torino.adaptadores;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.torino.R;
import com.example.torino.datos.Usuario;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Locale;


public class UsuarioAdapter extends BaseAdapter {

    private final Activity actividad;
    private  ArrayList<Usuario> lista;
    private ArrayList<Usuario> listaOriginal;

    public UsuarioAdapter(Activity actividad, ArrayList<Usuario> lista){
        super();
        this.actividad = actividad;
        this.lista = lista;
        listaOriginal = new ArrayList<>();
        listaOriginal.addAll(lista);
    }

    @Override
    public View getView(int posicion, View vista, ViewGroup padre) {
        LayoutInflater inflater = actividad.getLayoutInflater();
        View view = inflater.inflate( R.layout.elemento_usuarios, null, true);

        //TODO obtener vistas correspondientes a un elemento y asignarle valor

        Usuario unUsuario = lista.get(posicion);
        TextView nicknameUsuario = view.findViewById(R.id.tv_nombre_usuario);
        nicknameUsuario.setText(unUsuario.getNickname());

        Button seguir;
        seguir = view.findViewById(R.id.button_seguir);
        seguir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean resp = Usuario.setNuevoSeguido(nicknameUsuario.getText().toString());
                if (resp == false){
                    errorInesperado();
                }else{
                    seguidoExitosamente();
                }
            }
        });

        return view;
    }

    public void seguidoExitosamente() {
        Toast.makeText(actividad.getApplicationContext(), "Usuario seguido", Toast.LENGTH_LONG)
                .show();
    }

    public void errorInesperado() {
        Toast.makeText(actividad.getApplicationContext(), "Ocurrió un error inesperado", Toast.LENGTH_LONG)
                .show();
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
        Usuario unUsuario = lista.get(arg0);
        return unUsuario.getId();
    }

    public void filtrar (String nick){
        ArrayList<Usuario> listaFiltrada = new ArrayList<>();
        for (Usuario usuario : listaOriginal ){
            if (usuario.getNickname().toLowerCase().contains(nick.toLowerCase())){
                listaFiltrada.add(usuario);
            }
        }
        lista = listaFiltrada;
        notifyDataSetChanged();
    }


}