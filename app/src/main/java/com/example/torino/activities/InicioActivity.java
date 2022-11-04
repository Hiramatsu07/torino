package com.example.torino.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.torino.R;
import com.example.torino.datos.Usuario;

public class InicioActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private EditText campoEmail;
    private EditText campoPassword;
    Button login;
    TextView crear_cuenta;
    Usuario usuariologueado, usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: Inicia la creacion de la ctividad");
        setContentView(R.layout.activity_inicio);
        login = findViewById(R.id.button_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                campoEmail = (EditText) findViewById(R.id.email);
                campoPassword = (EditText) findViewById(R.id.password);

                String email = campoEmail.getText().toString();
                String password = campoPassword.getText().toString();

                boolean estaComprobado = Usuario.comprobarCredenciales(email, password);

                if (estaComprobado) {
                    Log.i(TAG, "Credenciales correctas");
                    usuariologueado = Usuario.usuarioExiste(email);
                    Usuario.setUsuarioLogueado(usuariologueado);

                    desplegarMensajeCredencialesCorrectas();
                    Intent intentFeed = new Intent( view.getContext(), CargarFragmentosActivity.class );
                    startActivity( intentFeed );
                } else {
                    Log.i(TAG, "Las credenciales son incorrectas");
                    desplegarMensajeCredencialesIncorrectas();

                }

            }
        });
        crear_cuenta = findViewById(R.id.link_crear_cuenta);
        crear_cuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent intentLogin = new Intent(view.getContext(), CrearCuentaActivity.class);
                startActivity(intentLogin);
            }
        });

    }

    public void desplegarMensajeCredencialesIncorrectas() {
        Toast.makeText(getApplicationContext(), "Credenciales incorrectas", Toast.LENGTH_SHORT)
                .show();
    }
    public void desplegarMensajeCredencialesCorrectas() {
        Toast.makeText(getApplicationContext(), "Sesión iniciada correctamente", Toast.LENGTH_SHORT)
                .show();
    }

    private void setUsuarioLogueado() {
        String email = campoEmail.getText().toString();
        Usuario.setUsuarioLogueado( Usuario.getUsuario( email ));
    }

}
