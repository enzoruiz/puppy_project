package com.enzoruiz.puppyproject.db;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Enzo on 28/04/2017.
 */

public class ConstantesBaseDatos {

    public static final String DATABASE_NAME = "puppies";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_PUPPIES = "puppy";
    public static final String TABLE_PUPPIES_ID = "id";
    public static final String TABLE_PUPPIES_NOMBRE = "nombre";
    public static final String TABLE_PUPPIES_CANTIDAD_LIKES = "cantidad_likes";
    public static final String TABLE_PUPPIES_FOTO = "foto";
    public static final String TABLE_PUPPIES_FECHA = "fecha";

    public static String getDateTime(){
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        return timeStamp;
    }

}
