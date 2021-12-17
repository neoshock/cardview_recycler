package com.example.listview_cardview;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EvaluadoresService {
    @GET("listadoevaluadores.php")
    Call<ListaEvaluador> getEvaluadores();
}
