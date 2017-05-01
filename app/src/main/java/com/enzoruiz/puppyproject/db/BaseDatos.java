package com.enzoruiz.puppyproject.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.enzoruiz.puppyproject.pojos.Puppy;

import java.util.ArrayList;

/**
 * Created by Enzo on 28/04/2017.
 */

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaPuppy = "CREATE TABLE " + ConstantesBaseDatos.TABLE_PUPPIES + "(" +
                                        ConstantesBaseDatos.TABLE_PUPPIES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                        ConstantesBaseDatos.TABLE_PUPPIES_NOMBRE + " TEXT, " +
                                        ConstantesBaseDatos.TABLE_PUPPIES_CANTIDAD_LIKES + " INTEGER DEFAULT 0, " +
                                        ConstantesBaseDatos.TABLE_PUPPIES_FOTO + " INTEGER, " +
                                        ConstantesBaseDatos.TABLE_PUPPIES_FECHA + " DATETIME"
                                        + ")";
        db.execSQL(queryCrearTablaPuppy);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_PUPPIES);
        onCreate(db);
    }

    public ArrayList<Puppy> getPuppies(){
        ArrayList<Puppy> puppies = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_PUPPIES;
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Puppy puppy = new Puppy();
            puppy.setId(registros.getInt(0));
            puppy.setNombre(registros.getString(1));
            puppy.setCantidadLikes(registros.getInt(2));
            puppy.setFoto(registros.getInt(3));
            puppy.setFecha(registros.getString(4));

            puppies.add(puppy);
        }

        db.close();

        return puppies;
    }

    public void insertarPuppy(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_PUPPIES, null, contentValues);
        db.close();
    }

    public int insertarLike(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = ConstantesBaseDatos.TABLE_PUPPIES_ID + " = ?";
        String[] selectionArgs = { contentValues.getAsString(ConstantesBaseDatos.TABLE_PUPPIES_ID) };
        int id = db.update(ConstantesBaseDatos.TABLE_PUPPIES, contentValues, selection, selectionArgs);
        db.close();
        return id;
    }

    public Puppy getPuppyById(int id){
        Puppy puppy = new Puppy();
        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_PUPPIES + " WHERE " + ConstantesBaseDatos.TABLE_PUPPIES_ID + " = " + String.valueOf(id);
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor registro = db.rawQuery(query, null);

        if(registro != null){
            registro.moveToFirst();
        }

        puppy.setId(registro.getInt(registro.getColumnIndex(ConstantesBaseDatos.TABLE_PUPPIES_ID)));
        puppy.setNombre(registro.getString(registro.getColumnIndex(ConstantesBaseDatos.TABLE_PUPPIES_NOMBRE)));
        puppy.setFecha(registro.getString(registro.getColumnIndex(ConstantesBaseDatos.TABLE_PUPPIES_FECHA)));
        puppy.setFoto(registro.getInt(registro.getColumnIndex(ConstantesBaseDatos.TABLE_PUPPIES_FOTO)));
        puppy.setCantidadLikes(registro.getInt(registro.getColumnIndex(ConstantesBaseDatos.TABLE_PUPPIES_CANTIDAD_LIKES)));

        return puppy;
    }

    public ArrayList<Puppy> getLastFivePuppies(){
        ArrayList<Puppy> puppies = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_PUPPIES +
                        " WHERE " + ConstantesBaseDatos.TABLE_PUPPIES_CANTIDAD_LIKES + " > 0" +
                        " ORDER BY " + ConstantesBaseDatos.TABLE_PUPPIES_FECHA +
                        " DESC LIMIT 5";
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Puppy puppy = new Puppy();
            puppy.setId(registros.getInt(0));
            puppy.setNombre(registros.getString(1));
            puppy.setCantidadLikes(registros.getInt(2));
            puppy.setFoto(registros.getInt(3));
            puppy.setFecha(registros.getString(4));

            puppies.add(puppy);
        }

        db.close();

        return puppies;
    }

}
