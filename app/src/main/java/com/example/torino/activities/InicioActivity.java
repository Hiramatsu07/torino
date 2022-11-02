package com.example.torino.activities;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.torino.R;
import com.example.torino.datos.Usuario;

public class InicioActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private EditText campoEmail;
    private EditText campoPassword;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: Inicia la creacion de la ctividad");
        setContentView(R.layout.activity_login);
        login = findViewById(R.id.button_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                campoEmail = (EditText) findViewById(R.id.email);
                campoPassword = (EditText) findViewById(R.id.password);
                iniciarSesion(view);
            }
        });

    }

    public void iniciarSesion(View view) {
        String email = campoEmail.getText().toString();
        String password = campoPassword.getText().toString();

        boolean estaComprobado = Usuario.comprobarCredenciales(email, password);

        if (estaComprobado) {
            Log.i(TAG, "Credenciales correctas");
            setUsuarioLogueado();
            Intent intentFeed = new Intent( this, FeedActivity.class );
            startActivity( intentFeed );
        } else {
            Log.i(TAG, "Las credenciales son incorrectas");
            desplegarMensajeCredencialesIncorrectas();
        }

    }

    public void desplegarMensajeCredencialesIncorrectas() {
        new AlertDialog.Builder(this)                 .setTitle("Credenciales incorrectas:")    .setMessage("Ingrese usuario y contraseña").setPositiveButton("Ok", null) .show();
        Toast.makeText(getApplicationContext(), "Credenciales incorrectas", Toast.LENGTH_SHORT)
                .show();
    }

    private void setUsuarioLogueado() {
        String email = campoEmail.getText().toString();
        Usuario.setUsuarioLogueado( Usuario.getUsuario( email ));
    }

}
