package com.enzoruiz.puppyproject.adaptadores;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.enzoruiz.puppyproject.R;
import com.enzoruiz.puppyproject.pojos.Puppy;

import java.util.ArrayList;


/**
 * Created by Enzo on 26/04/2017.
 */

public class PuppyHistorialAdapter extends RecyclerView.Adapter<PuppyHistorialAdapter.PuppyHistorialViewHolder> {

    ArrayList<Puppy> lista_puppies;

    public PuppyHistorialAdapter(ArrayList<Puppy> lista_puppies){
        this.lista_puppies = lista_puppies;
    }

    @Override
    public PuppyHistorialViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_puppy_historial, parent, false);
        return new PuppyHistorialAdapter.PuppyHistorialViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PuppyHistorialViewHolder puppyHistorialViewHolder, int position) {
        Puppy puppy = lista_puppies.get(position);
        puppyHistorialViewHolder.ivPuppyFotoPerfilHistorial.setImageResource(puppy.getFoto());
        puppyHistorialViewHolder.tvCantidadLikesHistorial.setText(String.valueOf(puppy.getCantidadLikes()));
    }

    @Override
    public int getItemCount() {
        return lista_puppies.size();
    }

    public static class PuppyHistorialViewHolder extends RecyclerView.ViewHolder{

        ImageView ivPuppyFotoPerfilHistorial;
        TextView tvCantidadLikesHistorial;

        public PuppyHistorialViewHolder(View itemView) {
            super(itemView);

            ivPuppyFotoPerfilHistorial = (ImageView) itemView.findViewById(R.id.ivPuppyFotoPerfilHistorial);
            tvCantidadLikesHistorial = (TextView) itemView.findViewById(R.id.tvCantidadLikesHistorial);

        }
    }

}
