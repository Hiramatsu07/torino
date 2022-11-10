package com.example.torino.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.torino.R;
import com.example.torino.adaptadores.ChatAdapter;
import com.example.torino.datos.Chats;
import com.example.torino.datos.Usuario;

public class ChatsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chats);


        ListView listView = findViewById(R.id.lista_chats);
        listView.setAdapter(new ChatAdapter(this, Chats.chatsInicialesFicticios));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                Intent intent = new Intent( ChatsActivity.this, VerMensajeDirectoActivity.class);
                intent.putExtra("idChat",i);
                startActivity( intent );
            }
        });

    }
}
