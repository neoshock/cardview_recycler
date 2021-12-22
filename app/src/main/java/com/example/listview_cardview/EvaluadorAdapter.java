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

public class EvaluadorAdapter extends RecyclerView.Adapter<EvaluadorAdapter.ViewHolder> {

    private int layout;
    private List<Evaluador> evaluadores;
    private OnItemClickListener itemClickListener;
    private Context context;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(evaluadores.get(position), itemClickListener, this.context);
    }

    @Override
    public int getItemCount() {
        return evaluadores.size();
    }

    public EvaluadorAdapter(List<Evaluador> evaluadores, int layout, @NonNull OnItemClickListener listener, Context context){
        this.evaluadores = evaluadores;
        this.layout = layout;
        this.itemClickListener = listener;
        this.context = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nombre;
        public TextView area;
        public ImageView imagen;

        public  ViewHolder(View view){
            super(view);
            this.nombre = view.findViewById(R.id.nombreEvaluador);
            this.area = view.findViewById(R.id.areaEvaluador);
            this.imagen = view.findViewById(R.id.evaluadorImg);
        }

        public void bind(final Evaluador evaluador, final OnItemClickListener listener, Context context){
            this.nombre.setText("Nombres: " + evaluador.getNombres());
            this.area.setText("Area: " + evaluador.getArea());

            /*Picasso.get().load(evaluador.getImgjpg()).
                    error(R.drawable.error_img).centerCrop().resize(300,300).into(this.imagen);*/

            Glide.with(context).load(evaluador.getImgjpg()).placeholder(R.drawable.error_img).into(imagen);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    listener.onClick(evaluador.getIdevaluador(), getAdapterPosition());
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onClick(String v, int position);
    }
}
