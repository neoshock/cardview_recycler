package com.example.listview_cardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
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

public class Evaluados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluados);
        loadDataEvaluados();
    }

    public void loadDataEvaluados(){
        Bundle bundle = this.getIntent().getExtras();
        String evaluador = bundle.getString("idevaluador");

        Retrofit retrofit = new Retrofit.Builder().
                baseUrl("https://www.uealecpeterson.net/ws/").
                addConverterFactory(GsonConverterFactory.create()).build();
        EvaluadoresService evaluadoresService = retrofit.create(EvaluadoresService.class);
        Call<ListaEvaluar> callData = evaluadoresService.getEvaluadosByEvaluador(evaluador);

        callData.enqueue(new Callback<ListaEvaluar>() {
            @Override
            public void onResponse(Call<ListaEvaluar> call, Response<ListaEvaluar> response) {
                ListaEvaluar evaluadosResponse = response.body();
                loadListEvaluado(evaluadosResponse.listaaevaluar);
            }

            @Override
            public void onFailure(Call<ListaEvaluar> call, Throwable t) {
                Toast.makeText(Evaluados.this, t.getMessage().toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void loadListEvaluado(List<Evaluado> evaluados){
        RecyclerView recyclerView = findViewById(R.id.listaEvaluados);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        RecyclerView.Adapter evaluadoAdapter = new EvaluadoAdapter(evaluados, R.layout.list_evaluados);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(evaluadoAdapter);
    }
}