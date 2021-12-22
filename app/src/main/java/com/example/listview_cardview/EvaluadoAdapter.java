package com.example.listview_cardview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

public class EvaluadoAdapter extends RecyclerView.Adapter<EvaluadoAdapter.EvaluadosViewHolder> {
    private int layout;
    private List<Evaluado> evaluados;
    private Context context;

    @NonNull
    @Override
    public EvaluadosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
        return new EvaluadosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EvaluadosViewHolder holder, int position) {
        holder.bind(evaluados.get(position), this.context);
    }

    @Override
    public int getItemCount() {
        return evaluados.size();
    }

    public EvaluadoAdapter(List<Evaluado> evaluados, int layout, Context context){
        this.evaluados = evaluados;
        this.layout = layout;
        this.context = context;
    }

    public static class EvaluadosViewHolder extends RecyclerView.ViewHolder {
        public TextView nombres;
        public TextView cargo;
        public TextView genero;
        public TextView situacion;
        public TextView fechaInicio;
        public TextView fechaFin;
        public ImageView imageView;

        public EvaluadosViewHolder(View view){
            super(view);
            this.nombres = view.findViewById(R.id.evaluadoNombre);
            this.cargo = view.findViewById(R.id.evaluadoCargo);
            this.genero = view.findViewById(R.id.evaluadoGenero);
            this.situacion = view.findViewById(R.id.evaluadoSituacion);

            this.fechaInicio = view.findViewById(R.id.fechaInicio);
            this.fechaFin = view.findViewById(R.id.fechaFin);
            this.imageView = view.findViewById(R.id.evaluadoImg);
        }

        public void bind(final Evaluado evaluado, Context context){
            /*Picasso.get().load(evaluado.getImgjpg()).
                    error(R.drawable.error_img).
                    into(this.imageView);*/

            this.nombres.setText("Nombres: " + evaluado.getNombres());
            this.cargo.setText("Cargo: " + evaluado.getCargo());
            this.genero.setText("Genero: " + evaluado.getGenero());
            this.situacion.setText("Situacion: " + evaluado.getSituacion());
            this.fechaFin.setText("Fecha Fin: " + evaluado.getFechafin());
            this.fechaInicio.setText("Fecha Inicio: " + evaluado.getFechainicio());

            Glide.with(context).load(evaluado.getImgjpg()).placeholder(R.drawable.error_img).into(imageView);

            if(evaluado.getFechafin() == null){
                this.fechaFin.setText("Fecha Fin: Ninguna");
            }
            if (evaluado.getFechainicio() == null){
                this.fechaInicio.setText("Fecha Inicio: Ninguna");
            }
        }
    }
}
