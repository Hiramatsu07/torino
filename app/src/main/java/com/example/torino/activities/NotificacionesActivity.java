package com.example.torino.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.torino.R;
import com.example.torino.adaptadores.ChatAdapter;
import com.example.torino.adaptadores.NotificacionAdaptador;
import com.example.torino.datos.Chats;
import com.example.torino.datos.Notificacion;

public class NotificacionesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificacion);

        ListView listView = findViewById(R.id.lista_notificaciones);
        listView.setAdapter(new NotificacionAdaptador(this, Notificacion.notificaciones));
    }
}
