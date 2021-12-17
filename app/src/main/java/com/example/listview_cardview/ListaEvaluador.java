package com.example.listview_cardview;

import java.util.List;

public class ListaEvaluador {
    List<Evaluador> listaaevaluador;

    public ListaEvaluador(List<Evaluador> listaaevaluador) {
        this.listaaevaluador = listaaevaluador;
    }

    public List<Evaluador> getListaaevaluador() {
        return listaaevaluador;
    }

    public void setListaaevaluador(List<Evaluador> listaaevaluador) {
        this.listaaevaluador = listaaevaluador;
    }
}
