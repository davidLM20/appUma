package com.example.appuma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class menuMesero extends AppCompatActivity {

    TextView tvBoton;
    TextView tvBoton2;
    TextView tvBoton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_mesero);

        tvBoton = (TextView) findViewById(R.id.btnMenuDia);

        tvBoton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                //finish();

                Intent i = new Intent(menuMesero.this, cargarMenu.class);
                startActivity(i);

            }
        });
        //botones para la creacion de pedido
        tvBoton2 = (TextView) findViewById(R.id.btnCreacionPedido);

        tvBoton2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                //finish();

                Intent i = new Intent(menuMesero.this, platosdelPedido.class);
                startActivity(i);

            }
        });
        //botones para agregar platos a un pedido
        tvBoton3 = (TextView) findViewById(R.id.btnAgregarPlato);

        tvBoton3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                //finish();

                Intent i = new Intent(menuMesero.this, agregarAdicionales.class);
                startActivity(i);

            }
        });
    }
}