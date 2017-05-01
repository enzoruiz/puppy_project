package com.enzoruiz.puppyproject.fragments;

import com.enzoruiz.puppyproject.adaptadores.PuppyAdapter;
import com.enzoruiz.puppyproject.pojos.Puppy;

import java.util.ArrayList;

/**
 * Created by Enzo on 28/04/2017.
 */

public interface IListaFragmentView {

    public void generarLinearLayoutManager();

    public PuppyAdapter crearAdaptador(ArrayList<Puppy> lista_puppies);

    public void inicializarAdaptadorRecyclerView(PuppyAdapter puppyAdapter);

}
