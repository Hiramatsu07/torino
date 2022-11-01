package com.example.torino.activities;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.torino.R;
import com.example.torino.datos.Usuario;

public class InicioActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private EditText campoNombreUsuario;
    private EditText campoPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: Inicia la creacion de la ctividad");
        setContentView(R.layout.activity_login);

        //campoNombreUsuario = (EditText) findViewById(R.id.nombre_usuario );
        //campoPassword = (EditText) findViewById(R.id.contrasenha );
    }

    public void iniciarSesion(View view) {
        String email = campoNombreUsuario.getText().toString();
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
        String email = campoNombreUsuario.getText().toString();
        Usuario.setUsuarioLogueado( Usuario.getUsuario( email ));
    }

}
