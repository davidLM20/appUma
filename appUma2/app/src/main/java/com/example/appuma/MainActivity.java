package com.example.appuma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    TextView tvBoton;
    EditText edtUsuario, edtPass;
    Button btnIngresar;
    String usuario,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //tvBoton = (TextView) findViewById(R.id.btnIngreso);

        edtUsuario = findViewById(R.id.editTextUsuario);
        edtPass = findViewById(R.id.editTextPassword);
        btnIngresar = findViewById(R.id.btnIngreso);



        recuperarPreferencias();

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //edtUsuario.setText("12002");
                //edtPass.setText("gabda02");
                usuario=edtUsuario.getText().toString();
                pass = edtPass.getText().toString();
                if(!usuario.isEmpty() && !pass.isEmpty()){
                    validarUsuario("http://192.168.1.3/uma/validar_usuario.php");
                }else{
                    Toast.makeText(MainActivity.this,"No se permiten campos vacios",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void validarUsuario(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(!response.isEmpty()){
                    guardarPreferencias();
                    String cadena = response.toString();
                    //Toast.makeText(MainActivity.this, cadena, Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(),menuMesero.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(MainActivity.this,"Usuario o Password Invalido", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,error.toString(),Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros=new HashMap<String,String>();
                parametros.put("cedula",usuario);
                parametros.put("codigo",pass);
                //parametros.put("cedula","12002");
                //parametros.put("codigo","gabda02");
                return parametros;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    private void guardarPreferencias(){
        SharedPreferences preferences = getSharedPreferences("preferenciasLogin", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("cedula",usuario);
        editor.putString("password",pass);
        editor.putBoolean("sesion",true);
        editor.commit();
    }

    private void recuperarPreferencias(){
        SharedPreferences preferences=getSharedPreferences("preferenciasLogin",Context.MODE_PRIVATE);
        edtUsuario.setText(preferences.getString("cedula","mail@mail.com"));
        edtPass.setText(preferences.getString("password","123456"));
    }
}