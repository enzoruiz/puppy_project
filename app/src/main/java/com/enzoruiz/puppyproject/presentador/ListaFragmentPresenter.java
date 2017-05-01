package com.enzoruiz.puppyproject.presentador;

import android.content.Context;

import com.enzoruiz.puppyproject.db.ConstructorPuppy;
import com.enzoruiz.puppyproject.fragments.IListaFragmentView;
import com.enzoruiz.puppyproject.pojos.Puppy;

import java.util.ArrayList;

/**
 * Created by Enzo on 28/04/2017.
 */

public class ListaFragmentPresenter implements IListaFragmentPresenter {

    private IListaFragmentView iListaFragmentView;
    private Context context;
    private ConstructorPuppy constructorPuppy;
    private ArrayList<Puppy> lista_puppies;

    public ListaFragmentPresenter(IListaFragmentView iListaFragmentView, Context context){
        this.iListaFragmentView = iListaFragmentView;
        this.context = context;
        obtenerPuppiesBD();
    }

    @Override
    public void obtenerPuppiesBD() {
        constructorPuppy = new ConstructorPuppy(context);
        lista_puppies = constructorPuppy.obtenerDatos();
        mostrarPuppiesRV();
    }

    @Override
    public void mostrarPuppiesRV() {
        iListaFragmentView.inicializarAdaptadorRecyclerView(iListaFragmentView.crearAdaptador(lista_puppies));
        iListaFragmentView.generarLinearLayoutManager();
    }
}
