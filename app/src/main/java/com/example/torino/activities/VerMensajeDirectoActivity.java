package com.example.torino.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.torino.R;
import com.example.torino.Utils.LogUtils;
import com.example.torino.datos.Chats;

public class VerMensajeDirectoActivity extends AppCompatActivity {
    private static final String TAG = "VerDatosGrupoActivity";
    private int idChat = 0;
    private Chats unChat;
    private TextView nombre;
    private TextView estado;
    private ImageView imagenUsuario;
    private int imgSeleccionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(LogUtils.tag, "Inicia metodo en VerMensajeDirectoActivity.onCreate");
        setContentView(R.layout.activity_mensaje_directo);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            idChat = extras.getInt("idChat", 0);
            Log.i(LogUtils.tag, "Id recibido del chat: "+idChat);
        }

        actualizarVista();
    }

    //Actualizamos para obtener los datos del usuario seleccionado
    public void actualizarVista(){


        unChat = Chats.chatsInicialesFicticios.get( idChat );

        nombre = (TextView) findViewById(R.id.nombre_usuario_a_mensajear);
        nombre.setText( unChat.getMensajero().getNickname() );

        estado = (TextView) findViewById(R.id.estado_usuario_mensaje_directo);
        estado.setText(unChat.getEstado());

        imagenUsuario = (ImageView) findViewById(R.id.imageview1);

        if(idChat==0){
            imgSeleccionada=R.drawable.ch;
        }else if(idChat==1){
            imgSeleccionada=R.drawable.foto_perfil;
        }else if(idChat==2){
            imgSeleccionada=R.drawable.cha;
        } else {
            imgSeleccionada=R.drawable.chica;
        }
        imagenUsuario.setBackgroundResource(imgSeleccionada);


    }
}
