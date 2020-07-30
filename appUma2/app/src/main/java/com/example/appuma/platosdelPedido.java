package com.example.appuma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class platosdelPedido extends AppCompatActivity {
    Button btnCargarPedido;
    EditText edtNumPedido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_platos_del_pedido);

        btnCargarPedido = findViewById(R.id.buttonCargar);
        edtNumPedido = findViewById(R.id.editTextNumPedido);

        btnCargarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                consultarPedidos("http://192.168.1.3/uma/consultar_pedido.php");

            }
        });
    }

    private void consultarPedidos(String URL){

        JsonArrayRequest arrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                int numPedido =0;
                Toast.makeText(platosdelPedido.this,response.toString(),Toast.LENGTH_LONG).show();
                for (int i =0;i<response.length();i++){
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        numPedido = jsonObject.getInt("numeroPedido");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                numPedido+=1;
                edtNumPedido.setText(String.valueOf(numPedido));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(platosdelPedido.this,error.toString(),Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(arrayRequest);
    }
}