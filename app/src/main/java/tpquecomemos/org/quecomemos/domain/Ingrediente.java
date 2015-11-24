package tpquecomemos.org.quecomemos.domain;

import java.io.Serializable;

/**
 * Created by Ivan on 19/11/2015.
 */
public class Ingrediente implements Serializable {
    String nombre;
    int cantidadEnGr;

    public Ingrediente(String nombreIngrediente, int cantidad){
        this.nombre = nombreIngrediente;
        this.cantidadEnGr = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String dificultad) {
        this.nombre = nombre;
    }

    public int getCantidadEnGr() {
        return cantidadEnGr;
    }

    @Override
    public String toString(){
        return this.nombre;
    }

    public void setCantidadEnGr(int cantidadEnGr) {
        this.cantidadEnGr = cantidadEnGr;
    }
}
