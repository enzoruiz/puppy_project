package com.enzoruiz.puppyproject.db;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import com.enzoruiz.puppyproject.R;
import com.enzoruiz.puppyproject.pojos.Puppy;

import java.util.ArrayList;

/**
 * Created by Enzo on 28/04/2017.
 */

public class ConstructorPuppy {

    private Context context;
    ContentValues contentValues;
    ArrayList<Puppy> lista_puppies;

    public ConstructorPuppy(Context context){
        this.context = context;
    }

    public ArrayList<Puppy> obtenerDatos(){
        BaseDatos bd = new BaseDatos(context);

        //insertarDataDummy(bd);

        lista_puppies = bd.getPuppies();

        return lista_puppies;
    }

    public ArrayList<Puppy> obtenerCincoUltimos(){
        BaseDatos bd = new BaseDatos(context);

        lista_puppies = bd.getLastFivePuppies();

        return lista_puppies;
    }

    public void insertarDataDummy(BaseDatos bd){
        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PUPPIES_NOMBRE, "Pepe");
        contentValues.put(ConstantesBaseDatos.TABLE_PUPPIES_FOTO, R.drawable.dog_face);
        contentValues.put(ConstantesBaseDatos.TABLE_PUPPIES_FECHA, ConstantesBaseDatos.getDateTime());
        bd.insertarPuppy(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PUPPIES_NOMBRE, "Tomas");
        contentValues.put(ConstantesBaseDatos.TABLE_PUPPIES_FOTO, R.drawable.dog_face2);
        contentValues.put(ConstantesBaseDatos.TABLE_PUPPIES_FECHA, ConstantesBaseDatos.getDateTime());
        bd.insertarPuppy(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PUPPIES_NOMBRE, "Dug");
        contentValues.put(ConstantesBaseDatos.TABLE_PUPPIES_FOTO, R.drawable.dug);
        contentValues.put(ConstantesBaseDatos.TABLE_PUPPIES_FECHA, ConstantesBaseDatos.getDateTime());
        bd.insertarPuppy(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PUPPIES_NOMBRE, "Douglas");
        contentValues.put(ConstantesBaseDatos.TABLE_PUPPIES_FOTO, R.drawable.dog_face3);
        contentValues.put(ConstantesBaseDatos.TABLE_PUPPIES_FECHA, ConstantesBaseDatos.getDateTime());
        bd.insertarPuppy(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PUPPIES_NOMBRE, "Ghost");
        contentValues.put(ConstantesBaseDatos.TABLE_PUPPIES_FOTO, R.drawable.dog_face4);
        contentValues.put(ConstantesBaseDatos.TABLE_PUPPIES_FECHA, ConstantesBaseDatos.getDateTime());
        bd.insertarPuppy(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PUPPIES_NOMBRE, "Buzz");
        contentValues.put(ConstantesBaseDatos.TABLE_PUPPIES_FOTO, R.drawable.dog_face5);
        contentValues.put(ConstantesBaseDatos.TABLE_PUPPIES_FECHA, ConstantesBaseDatos.getDateTime());
        bd.insertarPuppy(contentValues);
    }

    public int registrarLike(Puppy puppy){
        BaseDatos bd = new BaseDatos(context);
        int nuevaCantidadLikes = puppy.getCantidadLikes() + 1;

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PUPPIES_ID, puppy.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_PUPPIES_CANTIDAD_LIKES, nuevaCantidadLikes);
        contentValues.put(ConstantesBaseDatos.TABLE_PUPPIES_FECHA, ConstantesBaseDatos.getDateTime());

        return bd.insertarLike(contentValues);
    }

    public Puppy getPuppyById(int id){
        BaseDatos bd = new BaseDatos(context);
        return bd.getPuppyById(id);
    }

}
