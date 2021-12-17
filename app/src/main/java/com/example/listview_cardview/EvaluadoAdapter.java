package com.example.listview_cardview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EvaluadoAdapter extends RecyclerView.Adapter<EvaluadoAdapter.EvaluadosViewHolder> {
    private int layout;
    private List<Evaluado> evaluados;

    @NonNull
    @Override
    public EvaluadosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
        return new EvaluadosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EvaluadosViewHolder holder, int position) {
        holder.bind(evaluados.get(position));
    }

    @Override
    public int getItemCount() {
        return evaluados.size();
    }

    public EvaluadoAdapter(List<Evaluado> evaluados, int layout){
        this.evaluados = evaluados;
        this.layout = layout;
    }

    public static class EvaluadosViewHolder extends RecyclerView.ViewHolder {
        public TextView nombres;
        public TextView cargo;
        public TextView genero;
        public TextView situacion;
        public ImageView imageView;

        public EvaluadosViewHolder(View view){
            super(view);
            this.nombres = view.findViewById(R.id.evaluadoNombre);
            this.cargo = view.findViewById(R.id.evaluadoCargo);
            this.genero = view.findViewById(R.id.evaluadoGenero);
            this.situacion = view.findViewById(R.id.evaluadoSituacion);
            this.imageView = view.findViewById(R.id.evaluadoImg);
        }

        public void bind(final Evaluado evaluado){
            this.nombres.setText(evaluado.getNombres());
            this.cargo.setText(evaluado.getCargo());
            this.genero.setText(evaluado.getGenero());
            this.situacion.setText(evaluado.getSituacion());
        }
    }
}
