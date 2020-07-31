package com.example.appuma;

import Clases.Pedido;
import Clases.Plato;
import Clases.platoPedido;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class platosdelPedido extends AppCompatActivity implements AdapterView.OnItemClickListener{
    ArrayList<String> numeros = new ArrayList<>();
    Button btnCargarPedido, btnAgregarPlato;
    EditText edtNumPedido, plSel, edtObservacion;
    ListView listaPlatos;
    Spinner costo;
    int limite = 20;
    private ArrayList<String> Arrayplatos = new ArrayList<String>();
    ArrayList<Plato> platos = new ArrayList<Plato>();

    Plato platoSel = new Plato();
    Pedido objPedido = new Pedido();
    platoPedido objPlatoPedido = new platoPedido();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_platos_del_pedido);
        listaPlatos = (ListView) findViewById(R.id.listaPlatos);
        listaPlatos.setOnItemClickListener(this);
        consultarPlatos("http://192.168.1.3/uma/consultar_platos.php");
        costo = findViewById(R.id.cantidad);
        edtObservacion = findViewById(R.id.editTextObservacion);
        btnCargarPedido = findViewById(R.id.buttonCargar);

        edtNumPedido = findViewById(R.id.editTextNumPedido);
        for (int i=0; i<limite;i++){
            numeros.add(String.valueOf(i));
        }
        ArrayAdapter adapterCantidad = new ArrayAdapter(platosdelPedido.this, android.R.layout.simple_list_item_1, numeros);
        costo.setAdapter(adapterCantidad);

        btnCargarPedido.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                consultarPedidos("http://192.168.1.3/uma/consultar_pedido.php");

            }
        });
        btnAgregarPlato = findViewById(R.id.btnAgregarPlato);
        btnAgregarPlato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(platosdelPedido.this,"1",Toast.LENGTH_LONG);
                objPedido.setNumeroPedido(Integer.parseInt(edtNumPedido.getText().toString()));
                objPlatoPedido.setCantidad(Integer.parseInt(costo.getSelectedItem().toString()));
                //objPlatoPedido.setCantidad(3);
                objPlatoPedido.setPlato(platoSel);
                objPlatoPedido.setObservacion(edtObservacion.getText().toString());
                objPlatoPedido.setEstado(1);
                Toast.makeText(platosdelPedido.this,"1",Toast.LENGTH_LONG);
                registrarPlatoPedido("http://192.168.1.3/uma/registrar_platoPedido.php", objPlatoPedido);
                guardarPreferencias();
                Intent intent = new Intent(getApplicationContext(),crearPedido.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void registrarPlatoPedido(String URL, final platoPedido objPlatoPedido){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(!response.isEmpty()){
                    //guardarPreferencias();
                    String cadena = response.toString();
                    Toast.makeText(platosdelPedido.this, cadena, Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(platosdelPedido.this,"Usuario o Password Invalido", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(platosdelPedido.this,error.toString(),Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros=new HashMap<String,String>();
                //parametros.put("cedula",usuario);
                //parametros.put("codigo",pass);
                parametros.put("cantidad",String.valueOf(objPlatoPedido.getCantidad()));
                parametros.put("estado",String.valueOf(objPlatoPedido.getEstado()));
                parametros.put("observacion",objPlatoPedido.getObservacion());
                parametros.put("idPedido","1");
                parametros.put("idPlato",String.valueOf(objPlatoPedido.getPlato().getIdPlato()));
                return parametros;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    private void consultarPlatos(String URL) {
        JsonArrayRequest arrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for (int i = 0; i < response.length(); i++) {
                    Plato p = new Plato();
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        p.setIdPlato(jsonObject.getInt("idPlato"));
                        p.setNombre(jsonObject.getString("nombre"));
                        p.setDescripcion(jsonObject.getString("descripcion"));
                        p.setCosto(jsonObject.getDouble("costo"));
                        p.setTiempo(jsonObject.getDouble("tiempo"));
                        Arrayplatos.add(p.getNombre());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    platos.add(p);
                }
                //Toast.makeText(platosdelPedido.this, Arrayplatos.toString(),Toast.LENGTH_LONG).show();
                ArrayAdapter adapter = new ArrayAdapter(platosdelPedido.this, android.R.layout.simple_list_item_1, Arrayplatos);
                listaPlatos.setAdapter(adapter);
                //Arrayplatos = platos;
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(platosdelPedido.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(arrayRequest);
            //Toast.makeText(this,Arrayplatos.toString(),Toast.LENGTH_LONG).show();
        }


    private void consultarPedidos(String URL){

        JsonArrayRequest arrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                int numPedido =0;
                //Toast.makeText(platosdelPedido.this,response.toString(),Toast.LENGTH_LONG).show();
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

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        platoSel = platos.get(position);
        Toast.makeText(this,platoSel.getDescripcion(), Toast.LENGTH_LONG).show();
        plSel = findViewById(R.id.platoSel);
        plSel.setText(platoSel.getNombre());
    }
    private void guardarPreferencias(){
        SharedPreferences preferences = getSharedPreferences("preferenciasPedido", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("numPedido",(Integer.parseInt(edtNumPedido.getText().toString())));
        editor.putInt("idPlato",platoSel.getIdPlato());
        editor.putInt("cantidad", Integer.parseInt(costo.getSelectedItem().toString()));
        editor.putString("observacion",objPlatoPedido.getObservacion());
        editor.commit();
    }


}