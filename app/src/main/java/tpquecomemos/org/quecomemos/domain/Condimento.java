package tpquecomemos.org.quecomemos.domain;

/**
 * Created by hp on 22/11/2015.
 */
public class Condimento {

    String nombreCondimento;
    int cantidad;

    public Condimento(String nombreCondimento, int cantidad){
        this.nombreCondimento = nombreCondimento;
        this.cantidad = cantidad;
    }

    public String getNombreCondimento() {
        return nombreCondimento;
    }

    public void setNombreCondimento(String dificultad) {
        this.nombreCondimento = nombreCondimento;
    }

    public int getCantidad() {
        return cantidad;
    }

    @Override
    public String toString(){
        return this.nombreCondimento;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
