package com.enzoruiz.puppyproject.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.enzoruiz.puppyproject.R;
import com.enzoruiz.puppyproject.adaptadores.PuppyAdapter;
import com.enzoruiz.puppyproject.pojos.Puppy;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaFragment extends Fragment {

    private RecyclerView rvListaPuppies;
    private ArrayList<Puppy> lista_puppies;

    public ListaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_lista, container, false);

        rvListaPuppies = (RecyclerView) v.findViewById(R.id.rvListaPuppies);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvListaPuppies.setLayoutManager(llm);

        inicializarLista();
        inicializarAdaptador();

        return v;
    }

    public void inicializarLista(){
        lista_puppies = new ArrayList<>();
        lista_puppies.add(new Puppy("Pepe", R.drawable.dog_face, 2));
        lista_puppies.add(new Puppy("Douglas", R.drawable.dog_face, 3));
        lista_puppies.add(new Puppy("Ghost", R.drawable.dog_face, 4));
    }

    public void inicializarAdaptador(){
        PuppyAdapter puppyAdapter = new PuppyAdapter(lista_puppies);
        rvListaPuppies.setAdapter(puppyAdapter);
    }
}
