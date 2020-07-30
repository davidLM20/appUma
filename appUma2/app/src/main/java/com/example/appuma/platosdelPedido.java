package com.example.appuma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class platosdelPedido extends AppCompatActivity {
    TextView tvBoton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_platos_del_pedido);

        tvBoton = (TextView) findViewById(R.id.btnCrearPedido1);

        tvBoton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                //finish();

                Intent i = new Intent(platosdelPedido.this, crearPedido.class);
                startActivity(i);

            }
        });
    }
}