package com.example.listview_cardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        retrofitRequest();
    }

    private void retrofitRequest(){
        Retrofit retrofit = new Retrofit.Builder().
                baseUrl("https://www.uealecpeterson.net/ws/").
                addConverterFactory(GsonConverterFactory.create()).build();
        EvaluadoresService evaluadoresService = retrofit.create(EvaluadoresService.class);
        Call<ListaEvaluador> callData = evaluadoresService.getEvaluadores();

        callData.enqueue(new Callback<ListaEvaluador>() {
            @Override
            public void onResponse(Call<ListaEvaluador> call, Response<ListaEvaluador> response) {
                ListaEvaluador evaluadorsResponse = response.body();
                addList(evaluadorsResponse.listaaevaluador);
            }

            @Override
            public void onFailure(Call<ListaEvaluador> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage().toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void addList(List<Evaluador> evaluadors){
        RecyclerView recyclerView = findViewById(R.id.listaEvaluadores);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        RecyclerView.Adapter evaluadorAdapter = new EvaluadorAdapter(evaluadors,R.layout.list_item, new EvaluadorAdapter.OnItemClickListener() {
            @Override
            public void onClick(String view, int position){
                seleccionarEvaluador(view);
            }
        });
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(evaluadorAdapter);
    }

    private void seleccionarEvaluador(String evaluadorId){
        Bundle bundle = new Bundle();

        Intent intent = new Intent(MainActivity.this, Evaluados.class);

        //Agregamos los campos ingresados en los Inputs al bundle
        bundle.putString("idevaluador", evaluadorId);

        //Ingresamos la coleccion de datos al intent
        intent.putExtras(bundle);

        //Llamada a a la siguiente actividad
        startActivity(intent);
    }
}