package tpquecomemos.org.quecomemos.domain;

import java.io.Serializable;

/**
 * Created by Ivan on 17/11/2015.
 */
public class Receta implements Serializable {
    Long id;
    String nombre;
    String dificultad;
    String temporada;
    String instrucciones;
    String ingredientes;

    public Receta(String nombre, String dificultad, String temporada, String ingredientes, String instrucciones) {
        this.nombre = nombre;
        this.dificultad = dificultad;
        this.temporada = temporada;
        this.instrucciones = instrucciones;
        this.ingredientes = ingredientes;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String titulo) {
        this.nombre = titulo;
    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }

    public String toString() {
        return nombre;
    }



}