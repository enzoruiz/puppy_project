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
import com.enzoruiz.puppyproject.presentador.IListaFragmentPresenter;
import com.enzoruiz.puppyproject.presentador.ListaFragmentPresenter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaFragment extends Fragment implements IListaFragmentView {

    private RecyclerView rvListaPuppies;
    private ArrayList<Puppy> lista_puppies;
    private IListaFragmentPresenter iListaFragmentPresenter;

    public ListaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_lista, container, false);

        rvListaPuppies = (RecyclerView) v.findViewById(R.id.rvListaPuppies);

        iListaFragmentPresenter = new ListaFragmentPresenter(this, getContext());

        return v;
    }

    @Override
    public void generarLinearLayoutManager() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvListaPuppies.setLayoutManager(llm);
    }

    @Override
    public PuppyAdapter crearAdaptador(ArrayList<Puppy> lista_puppies) {
        PuppyAdapter puppyAdapter = new PuppyAdapter(lista_puppies, getActivity());
        return puppyAdapter;
    }

    @Override
    public void inicializarAdaptadorRecyclerView(PuppyAdapter puppyAdapter) {
        rvListaPuppies.setAdapter(puppyAdapter);
    }
}
