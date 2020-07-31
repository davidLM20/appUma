package com.example.appuma;

import Clases.Plato;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class crearPedido extends AppCompatActivity {
    int numMesa,numeroPedido,tiempoAproximado,estado,idMesero,idPlato,cantidad;
    ListView ListaPlatoPedido;
    ArrayList<String> platoPedido = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_pedido);
        recuperarPreferencias();
        recuperarPlato("http://192.168.1.3/uma/consultar_plato.php");
        ListaPlatoPedido = findViewById(R.id.listaPlatoPedido);

    }
    private void recuperarPlato(String URL){
        JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.POST, URL,null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Plato p = new Plato();
                try {
                    p.setIdPlato(response.getInt("idPlato"));
                    p.setNombre(response.getString("nombre"));
                    p.setDescripcion(response.getString("descripcion"));
                    p.setCosto(response.getDouble("costo"));
                    p.setTiempo(response.getDouble("tiempo"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                platoPedido.add(p.getNombre());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Toast.makeText(crearPedido.this,error.toString(),Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros=new HashMap<String,String>();
                //parametros.put("cedula",usuario);
                //parametros.put("codigo",pass);
                parametros.put("idPlato",String.valueOf(idPlato));
                Toast.makeText(crearPedido.this,idPlato,Toast.LENGTH_SHORT).show();
                return parametros;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
    private void recuperarPreferencias(){
        SharedPreferences preferences=getSharedPreferences("preferenciasPedido", Context.MODE_PRIVATE);
        numeroPedido = preferences.getInt("numPedido",1);
        idPlato = preferences.getInt("idPlato",17);
        cantidad = preferences.getInt("cantidad",1);
    }
}