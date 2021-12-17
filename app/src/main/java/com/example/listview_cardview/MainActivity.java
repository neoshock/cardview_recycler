package com.example.listview_cardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

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
        addList();
        retrofitRequest();
    }

    private void retrofitRequest(){
        Retrofit retrofit = new Retrofit.Builder().
                baseUrl("https://evaladmin.uteq.edu.ec/ws/").
                addConverterFactory(GsonConverterFactory.create()).build();
        EvaluadoresService evaluadoresService = retrofit.create(EvaluadoresService.class);
        Call<List<Evaluador>> callData = evaluadoresService.getEvaluadores();

        callData.enqueue(new Callback<List<Evaluador>>() {
            @Override
            public void onResponse(Call<List<Evaluador>> call, Response<List<Evaluador>> response) {

            }

            @Override
            public void onFailure(Call<List<Evaluador>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage().toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void addList(){
        RecyclerView recyclerView = findViewById(R.id.listaEvaluadores);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        List<String> nombres = new ArrayList<>();
        nombres.add("Manolo");
        nombres.add("Maria");
        nombres.add("Alejandro");

        RecyclerView.Adapter evaluadorAdapter = new EvaluadorAdapter(nombres,R.layout.list_item, new EvaluadorAdapter.OnItemClickListener() {
            @Override
            public void onClick(String view, int position){
                Toast.makeText(MainActivity.this, view, Toast.LENGTH_LONG).show();
            }
        });
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(evaluadorAdapter);
    }
}