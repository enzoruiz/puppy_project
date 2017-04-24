package com.enzoruiz.puppyproject;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Enzo on 24/04/2017.
 */

public class PuppyAdapter extends RecyclerView.Adapter<PuppyAdapter.PuppyViewHolder> {

    ArrayList<Puppy> lista_puppies;
    Activity activity;

    public PuppyAdapter(ArrayList<Puppy> lista_puppies){
        this.lista_puppies = lista_puppies;
    }

    @Override
    public PuppyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_puppy, parent, false);
        return new PuppyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PuppyViewHolder puppyViewHolder, int position) {
        final Puppy puppy = lista_puppies.get(position);
        puppyViewHolder.tvNombre.setText(puppy.getNombre());
        puppyViewHolder.tvCantidadLikes.setText(String.valueOf(puppy.getCantidadLikes()));
        puppyViewHolder.ivFoto.setImageResource(puppy.getFoto());
    }

    @Override
    public int getItemCount() {
        return lista_puppies.size();
    }

    public static class PuppyViewHolder extends RecyclerView.ViewHolder{

        ImageView ivFoto;
        TextView tvNombre, tvCantidadLikes;

        public PuppyViewHolder(View itemView) {
            super(itemView);

            ivFoto          = (ImageView) itemView.findViewById(R.id.ivFoto);
            tvNombre        = (TextView) itemView.findViewById(R.id.tvNombre);
            tvCantidadLikes = (TextView) itemView.findViewById(R.id.tvCantidadLikes);

        }
    }

}
