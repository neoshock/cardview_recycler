package com.example.listview_cardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Evaluados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluados);
    }

    public void loadListEvaluado(){

        List<Evaluado> evaluados = new ArrayList<>();
        RecyclerView recyclerView = findViewById(R.id.listaEvaluados);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        RecyclerView.Adapter evaluadoAdapter = new EvaluadoAdapter(evaluados, R.layout.list_evaluados);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(evaluadoAdapter);
    }
}