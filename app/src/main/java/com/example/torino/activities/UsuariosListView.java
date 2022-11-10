package com.example.torino.activities;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.torino.R;
import com.example.torino.adaptadores.UsuarioAdapter;
import com.example.torino.datos.Usuario;



public class UsuariosListView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_buscar_usuarios);

        ListView listView = findViewById(R.id.lista_usuarios);
        listView.setAdapter(new UsuarioAdapter(this, Usuario.usuarios));

    }
}