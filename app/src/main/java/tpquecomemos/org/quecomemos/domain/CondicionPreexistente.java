package tpquecomemos.org.quecomemos.domain;

/**
 * Created by hp on 22/11/2015.
 */
public class CondicionPreexistente {

    String nombreCondicion;

    public CondicionPreexistente(String nombreCondicion){
        this.nombreCondicion = nombreCondicion;
    }

    public String getNombreCondicion() {
        return nombreCondicion;
    }

    public void setNombreCondicion(String dificultad) {
        this.nombreCondicion = nombreCondicion;
    }


    @Override
    public String toString(){
        return this.nombreCondicion;
    }
}
