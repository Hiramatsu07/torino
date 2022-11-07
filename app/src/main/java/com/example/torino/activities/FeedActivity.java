package com.example.torino.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.torino.R;
import com.example.torino.adaptadores.FeedAdapter;
import com.example.torino.datos.Publicacion;
import com.example.torino.datos.Usuario;

public class FeedActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        Usuario unUsuario = Usuario.getUsuarioLogueado();
        ListView listView = findViewById(R.id.lista_grupos_cercanos);
        listView.setAdapter(new FeedAdapter(this, unUsuario.getFeed()));

    }
}
