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

public class CrearCuentaActivity extends AppCompatActivity {
    private EditText campoEmail;
    private EditText campoPassword;
    private EditText campoNickname;
    Button crear_cuenta;
    TextView iniciar_sesion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuenta);
        crear_cuenta = findViewById(R.id.button_crear_cuenta);
        crear_cuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                campoEmail = (EditText) findViewById(R.id.email);
                campoPassword = (EditText) findViewById(R.id.password);
                campoNickname = (EditText) findViewById(R.id.nickname);

                String email = campoEmail.getText().toString();
                String password = campoPassword.getText().toString();
                String nickname = campoNickname.getText().toString();

                boolean yaExiste = Usuario.existeCuenta(email, nickname);
                if (password.length() < 8) {
                    shortPassword();
                } else {
                    if (yaExiste == true) {
                        yaExisteMensaje();
                    } else {
                        if (yaExiste == false) {
                            cuentaCreada();
                            Usuario.usuarios.add(new Usuario(nickname, "", email, password, ""));
                            finish();
                            Intent intentLogin = new Intent(view.getContext(), InicioActivity.class);
                            startActivity(intentLogin);
                        }
                    }
                }
            }
        });
        iniciar_sesion = (TextView) findViewById(R.id.link_iniciar_sesion);
        iniciar_sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent intentLogin = new Intent(view.getContext(), InicioActivity.class);
                startActivity(intentLogin);
            }
        });
    }

    public void yaExisteMensaje() {
        Toast.makeText(getApplicationContext(), "Ya existe una cuenta con ese usuario y/o correo", Toast.LENGTH_LONG)
                .show();
    }
    public void cuentaCreada() {
        Toast.makeText(getApplicationContext(), "Cuenta creada exitosamente", Toast.LENGTH_LONG)
                .show();
    }
    public void shortPassword(){
        Toast.makeText(getApplicationContext(), "Contraseña demasiado corta, debe tener al menos 8 caracteres", Toast.LENGTH_LONG)
                .show();
    }
}
