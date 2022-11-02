package com.example.torino.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.example.torino.R;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate (Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    getSupportActionBar().hide();
    setContentView(R.layout.activity_inicio);
    }
    public void lanzarCrearCuenta(View view){
        Intent intentCrearCuenta = new Intent( this, CrearCuentaActivity.class );
        startActivity( intentCrearCuenta );
    }

    public void lanzarLogin(View view){
        Intent intentLogin = new Intent( this, InicioActivity.class );
        startActivity( intentLogin );
    }
}

