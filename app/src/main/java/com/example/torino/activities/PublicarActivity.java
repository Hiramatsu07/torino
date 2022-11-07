package com.example.torino.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.torino.R;
import com.example.torino.datos.Publicacion;

public class PublicarActivity extends AppCompatActivity {
    Button publicar;
    EditText descripcion;
    Boolean resultado = false;
    @Override
    protected void onCreate(Bundle savedInstanceStat){
        setContentView(R.layout.activity_publicar);
        publicar = findViewById(R.id.button);
        publicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                descripcion = (EditText) findViewById(R.id.publicacion_usuario);
                resultado = Publicacion.addNuevaPublicacion(descripcion.getText().toString());
                if (resultado == true){
                    publicadoExitosamente();
                }else{
                    errorInesperado();
                }
            }
        });
        super.onCreate(savedInstanceStat);

    }
    public void publicadoExitosamente() {
        Toast.makeText(getApplicationContext(), "Publicado correctamente", Toast.LENGTH_LONG)
                .show();
    }
    public void errorInesperado(){
        Toast.makeText(getApplicationContext(), "Ocurrió un error inesperado", Toast.LENGTH_LONG)
                .show();
}
