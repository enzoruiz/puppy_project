package com.enzoruiz.puppyproject.adaptadores;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.enzoruiz.puppyproject.R;
import com.enzoruiz.puppyproject.db.ConstructorPuppy;
import com.enzoruiz.puppyproject.pojos.Puppy;

import java.util.ArrayList;

/**
 * Created by Enzo on 24/04/2017.
 */

public class PuppyAdapter extends RecyclerView.Adapter<PuppyAdapter.PuppyViewHolder> {

    ArrayList<Puppy> lista_puppies;
    Activity activity;

    public PuppyAdapter(ArrayList<Puppy> lista_puppies, Activity activity){
        this.lista_puppies = lista_puppies;
        this.activity = activity;
    }

    @Override
    public PuppyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_puppy, parent, false);
        return new PuppyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final PuppyViewHolder puppyViewHolder, final int position) {
        final Puppy puppy = lista_puppies.get(position);
        puppyViewHolder.tvNombre.setText(puppy.getNombre());
        puppyViewHolder.tvCantidadLikes.setText(String.valueOf(puppy.getCantidadLikes()));
        puppyViewHolder.ivFoto.setImageResource(puppy.getFoto());

        puppyViewHolder.ibBoneLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConstructorPuppy constructorPuppy = new ConstructorPuppy(activity);
                lista_puppies = constructorPuppy.obtenerDatos();

                Puppy puppyEnLista = lista_puppies.get(position);

                constructorPuppy.registrarLike(puppyEnLista);

                Puppy puppyActualizado = constructorPuppy.getPuppyById(puppyEnLista.getId());

                puppyViewHolder.tvCantidadLikes.setText(String.valueOf(puppyActualizado.getCantidadLikes()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return lista_puppies.size();
    }

    public static class PuppyViewHolder extends RecyclerView.ViewHolder{

        ImageView ivFoto;
        ImageButton ibBoneLike;
        TextView tvNombre, tvCantidadLikes;

        public PuppyViewHolder(View itemView) {
            super(itemView);

            ivFoto          = (ImageView) itemView.findViewById(R.id.ivFoto);
            tvNombre        = (TextView) itemView.findViewById(R.id.tvNombre);
            tvCantidadLikes = (TextView) itemView.findViewById(R.id.tvCantidadLikes);
            ibBoneLike      = (ImageButton) itemView.findViewById(R.id.ibBoneLike);
        }
    }

}
