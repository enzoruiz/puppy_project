package com.enzoruiz.puppyproject.pojos;

/**
 * Created by Enzo on 24/04/2017.
 */

public class Puppy {

    private String nombre, fecha;
    private int id, foto, cantidadLikes;

    public Puppy(){

    }

    public Puppy(String nombre, int foto, int cantidadLikes){
        this.nombre = nombre;
        this.foto = foto;
        this.cantidadLikes = cantidadLikes;
        this.fecha = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
