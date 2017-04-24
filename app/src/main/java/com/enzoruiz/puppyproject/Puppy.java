package com.enzoruiz.puppyproject;

/**
 * Created by Enzo on 24/04/2017.
 */

public class Puppy {

    private String nombre;
    private int foto, cantidadLikes;

    public Puppy(String nombre, int foto, int cantidadLikes){
        this.nombre = nombre;
        this.foto = foto;
        this.cantidadLikes = cantidadLikes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getCantidadLikes() {
        return cantidadLikes;
    }

    public void setCantidadLikes(int cantidadLikes) {
        this.cantidadLikes = cantidadLikes;
    }
}
