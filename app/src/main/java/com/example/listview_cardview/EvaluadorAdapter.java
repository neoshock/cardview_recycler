package com.example.listview_cardview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EvaluadorAdapter extends RecyclerView.Adapter<EvaluadorAdapter.ViewHolder> {

    private int layout;
    private List<String> nombres;
    private OnItemClickListener itemClickListener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(nombres.get(position), itemClickListener);
    }

    @Override
    public int getItemCount() {
        return nombres.size();
    }

    public EvaluadorAdapter(List<String> nombres, int layout, @NonNull OnItemClickListener listener){
        this.nombres = nombres;
        this.layout = layout;
        this.itemClickListener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nombre;

        public  ViewHolder(View view){
            super(view);
            this.nombre = view.findViewById(R.id.nombreEvaluador);
        }

        public TextView getTextView() {
            return nombre;
        }

        public void bind(final String nombre, final OnItemClickListener listener){
            this.nombre.setText(nombre);
            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    listener.onClick(nombre, getAdapterPosition());
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onClick(String v, int position);
    }
}
