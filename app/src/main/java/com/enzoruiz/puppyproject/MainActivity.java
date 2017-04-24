package com.enzoruiz.puppyproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvListaPuppies;
    private ArrayList<Puppy> lista_puppies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvListaPuppies = (RecyclerView) findViewById(R.id.rvListaPuppies);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvListaPuppies.setLayoutManager(llm);

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
        rvListaPuppies.setAdapter(puppyAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mEstrella:
                Intent intent = new Intent(MainActivity.this, DetalleMascota.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.lista_menus, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
