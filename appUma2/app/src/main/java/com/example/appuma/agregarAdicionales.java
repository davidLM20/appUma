package com.example.appuma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class agregarAdicionales extends AppCompatActivity {
    TextView tvBoton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_adicionales);

        tvBoton = (TextView) findViewById(R.id.btnAgregarAdicionales);

        tvBoton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                //finish();

                Intent i = new Intent(agregarAdicionales.this, AgregarPlatoPedido.class);
                startActivity(i);

            }
        });
    }
}