package com.example.volley_1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.VoiceInteractor;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requisicao();
    }

    public void requisicao(){
        final TextView textView = (TextView) findViewById(R.id.text);
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://apiproduto.appdahora.com.br/movimento-operacao";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                textView.setText("Resposta: "+ response.toString());
            }


        } , error -> textView.setText("Algo deu errado !"));
        queue.add(stringRequest);
    }
}