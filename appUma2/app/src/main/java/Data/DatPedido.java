package Data;


import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.appuma.platosdelPedido;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import Clases.Pedido;

public class DatPedido {
    DatConexion objConexion = new DatConexion();
    String URL = objConexion.GET_PEDIDO;

    private ArrayList<Pedido> consultarPedidos(){
        ArrayList<Pedido> result =null;
        JsonArrayRequest arrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                ArrayList<Pedido> result = new ArrayList<>();
                int numPedido =0;
                for (int i =0;i<response.length();i++){
                    Pedido p = new Pedido();
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        p.setIdPedido(jsonObject.getInt("idPedido"));
                        p.setNumeroMesa(jsonObject.getInt("numMesa"));
                        p.setNumeroPedido(jsonObject.getInt("numeroPedido"));
                        p.setTiempoAproximado(jsonObject.getDouble("tiempoAproximado"));
                        p.setEstado(jsonObject.getInt("estado"));
                        p.setCocinero(jsonObject.getInt("idCocinero"));
                        p.setCajero(jsonObject.getInt("idCajero"));
                        p.setMesero(jsonObject.getInt("idMesero"));
                        result.add(p);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Toast.makeText(platosdelPedido.this,error.toString(),Toast.LENGTH_SHORT).show();
            }
        });
        //RequestQueue requestQueue = Volley.newRequestQueue();
        //requestQueue.add(arrayRequest);
        return result;
    }
}
