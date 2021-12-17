package com.example.listview_cardview;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface EvaluadoresService {
    @GET("listadoevaluadores.php")
    Call<ListaEvaluador> getEvaluadores();

    @GET("listadoaevaluar.php")
    Call<ListaEvaluar> getEvaluadosByEvaluador(@Query("e") String id);
}
