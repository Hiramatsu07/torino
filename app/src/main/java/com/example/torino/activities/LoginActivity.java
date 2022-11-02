package com.example.torino.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.torino.R;

public class LoginActivity extends AppCompatActivity {
    Button login;
    Button crear_cuenta;
    @Override
    protected void onCreate (Bundle savedInstanceState){
        setContentView(R.layout.activity_login);
        login = findViewById(R.id.button_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLogin = new Intent( view.getContext(), InicioActivity.class );
                startActivity( intentLogin );
            }
        });
        super.onCreate(savedInstanceState);

        crear_cuenta = findViewById(R.id.button_crear);
        crear_cuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCrearCuenta = new Intent(view.getContext(), CrearCuentaActivity.class );
                startActivity( intentCrearCuenta );
            }
        });

    }
}

