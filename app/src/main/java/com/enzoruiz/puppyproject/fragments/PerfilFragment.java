package com.enzoruiz.puppyproject.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.enzoruiz.puppyproject.R;
import com.enzoruiz.puppyproject.adaptadores.PuppyHistorialAdapter;
import com.enzoruiz.puppyproject.pojos.Puppy;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

    RecyclerView rvPuppyPerfil;
    ArrayList<Puppy> lista_puppies;

    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        rvPuppyPerfil = (RecyclerView) v.findViewById(R.id.rvPuppyPerfil);

        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);
        rvPuppyPerfil.setLayoutManager(glm);

        inicializarLista();
        inicializarAdaptador();

        return v;
    }

    public void inicializarLista(){
        lista_puppies = new ArrayList<>();
        lista_puppies.add(new Puppy("Pepe", R.drawable.dog_face, 2));
        lista_puppies.add(new Puppy("Douglas", R.drawable.dog_face, 3));
        lista_puppies.add(new Puppy("Ghost", R.drawable.dog_face, 4));
        lista_puppies.add(new Puppy("Pepe", R.drawable.dog_face, 6));
        lista_puppies.add(new Puppy("Douglas", R.drawable.dog_face, 1));
        lista_puppies.add(new Puppy("Ghost", R.drawable.dog_face, 4));
        lista_puppies.add(new Puppy("Pepe", R.drawable.dog_face, 6));
        lista_puppies.add(new Puppy("Douglas", R.drawable.dog_face, 1));
        lista_puppies.add(new Puppy("Ghost", R.drawable.dog_face, 4));
        lista_puppies.add(new Puppy("Pepe", R.drawable.dog_face, 6));
        lista_puppies.add(new Puppy("Douglas", R.drawable.dog_face, 1));
    }

    public void inicializarAdaptador(){
        PuppyHistorialAdapter puppyAdapter = new PuppyHistorialAdapter(lista_puppies);
        rvPuppyPerfil.setAdapter(puppyAdapter);
    }

}
