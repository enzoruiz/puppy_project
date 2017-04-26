package com.enzoruiz.puppyproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.enzoruiz.puppyproject.adaptadores.PuppyAdapter;
import com.enzoruiz.puppyproject.pojos.Puppy;

import java.util.ArrayList;

public class DetalleMascota extends AppCompatActivity {

    ArrayList<Puppy> lista_puppies;
    RecyclerView rvCincoUltimos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mascota_detalle);

        // PARA QUE APAREZCA EL BOTON ATRAS EN EL TOOLBAR
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rvCincoUltimos = (RecyclerView) findViewById(R.id.rvCincoUltimos);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvCincoUltimos.setLayoutManager(llm);

        inicializarLista();
        inicializarAdaptador();
    }

    public void inicializarLista(){
        lista_puppies = new ArrayList<>();
        lista_puppies.add(new Puppy("Pepe", R.drawable.dog_face, 2));
        lista_puppies.add(new Puppy("Douglas", R.drawable.dog_face, 3));
        lista_puppies.add(new Puppy("Ghost", R.drawable.dog_face, 4));
    }

    public void inicializarAdaptador(){
        PuppyAdapter puppyAdapter = new PuppyAdapter(lista_puppies);
        rvCincoUltimos.setAdapter(puppyAdapter);
    }

}
