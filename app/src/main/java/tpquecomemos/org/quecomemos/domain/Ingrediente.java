package tpquecomemos.org.quecomemos.domain;

import java.io.Serializable;

/**
 * Created by Ivan on 19/11/2015.
 */
public class Ingrediente implements Serializable {
    String nombreIngrediente;
    int cantidad;

    public Ingrediente(String nombreIngrediente, int cantidad){
        this.nombreIngrediente = nombreIngrediente;
        this.cantidad = cantidad;
    }

    public String getNombreIngrediente() {
        return nombreIngrediente;
    }

    public void setNombreIngrediente(String dificultad) {
        this.nombreIngrediente = nombreIngrediente;
    }

    public int getCantidad() {
        return cantidad;
    }

    @Override
    public String toString(){
        return this.nombreIngrediente;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
