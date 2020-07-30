package com.example.appuma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvBoton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvBoton = (TextView) findViewById(R.id.btnIngreso);

        tvBoton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                //finish();

                Intent i = new Intent(MainActivity.this, menuMesero.class);
                startActivity(i);

            }
        });
    }
}