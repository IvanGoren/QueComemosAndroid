package tpquecomemos.org.quecomemos.repo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import tpquecomemos.org.quecomemos.domain.Receta;

/**
 * Created by Ivan on 17/11/2015.
 */
public class RepoRecetas {

    private List<Receta> recetas;

    private static final int MAX_RESULTS = 10;

    /**
     * SINGLETON
     */
    private static RepoRecetas instance;

    private RepoRecetas() {
        recetas = new ArrayList<Receta>();
    }

    public static RepoRecetas getInstance() {
        if (instance == null) {
            instance = new RepoRecetas();
            instance.init();
        }
        return instance;
    }

    /**
     *
     *   Inicializacion Juego de Datos
     */
    private void init() {
        RepoRecetas.getInstance().agregarReceta(new Receta("Flan","Facil","Siempre","Azucar,Leche,Huevo","Google"));
        RepoRecetas.getInstance().agregarReceta(new Receta("Flan","Facil","Siempre","Azucar,Leche,Huevo","Google"));
        RepoRecetas.getInstance().agregarReceta(new Receta("Flan","Facil","Siempre","Azucar,Leche,Huevo","Google"));
    }

    public List<Receta> getRecetas(String titulo) {
        return getRecetas(titulo, MAX_RESULTS);
    }

    public List<Receta> getRecetas(String titulo, int max) {
        Iterator<Receta> it = recetas.iterator();
        List<Receta> result = new ArrayList<Receta>();
        while (it.hasNext() && max > 0) {
            Receta receta = it.next();
            max--;
            if (titulo == null || receta.getNombre().toUpperCase().contains(titulo.toUpperCase())) {
                result.add(receta);
            }
        }
        return result;
    }

    public Receta getReceta(Long id) {
        for (Receta receta : this.recetas) {
            if (receta.getId().equals(id)) {
                return receta;
            }
        }
        return null;
    }

    public void agregarReceta(Receta receta) {
        receta.setId(getMaximoId());
        recetas.add(receta);
    }

    public Long getMaximoId() {
        return new Long(recetas.size() + 1);
    }

    public List<String> getTitulosDeRecetas() {
        List<String> result = new ArrayList<>();
        for (Receta receta : this.getRecetas(null, 10)) {
            result.add(receta.getNombre());
        }
        return result;
    }


}
