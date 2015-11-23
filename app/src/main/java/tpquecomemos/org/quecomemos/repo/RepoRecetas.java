package tpquecomemos.org.quecomemos.repo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import tpquecomemos.org.quecomemos.domain.CondicionPreexistente;
import tpquecomemos.org.quecomemos.domain.Condimento;
import tpquecomemos.org.quecomemos.domain.Ingrediente;
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
        Receta receta1 =new Receta("Flan","Facil","Siempre","Azucar,Leche,Huevo","Paso1,paso2,paso3");
        Ingrediente azucar = new Ingrediente("Azucar",200);
        Ingrediente leche = new Ingrediente ("Leche",100);
        Ingrediente huevo = new Ingrediente("Huevo", 8);
        receta1.addIngrediente(azucar);
        receta1.addIngrediente(leche);
        receta1.addIngrediente(huevo);

        Condimento vainilla = new Condimento("Vainilla",200);
        receta1.addCondimento(vainilla);
        receta1.addCondicionPreexistente(new CondicionPreexistente("Vegano"));
        receta1.addCondicionPreexistente(new CondicionPreexistente("Hipertenso"));

        Receta receta2 =new Receta("Milanesa de pollo","Medio","Verano","1/2 kg de suprema de pollo,Pan rayado,6 Huevos, 1/2 Lts. de Aceite","Paso1, paso2");
        Ingrediente suprema = new Ingrediente("Suprema de pollo",500);
        Ingrediente panRallado = new Ingrediente ("Pan Rallado",100);
        Ingrediente huevo2 = new Ingrediente("Huevo", 2);
        Ingrediente aceite = new Ingrediente("Aceite", 500);
        receta2.addIngrediente(suprema);
        receta2.addIngrediente(panRallado);
        receta2.addIngrediente(huevo2);
        receta2.addIngrediente(aceite);

        Condimento sal = new Condimento("Sal",200);
        Condimento pimienta = new Condimento ("Pimienta",10);
        receta2.addCondimento(sal);
        receta2.addCondimento(pimienta);

        receta2.addCondicionPreexistente(new CondicionPreexistente("Vegano"));
        receta2.addCondicionPreexistente(new CondicionPreexistente("Diabetico"));

        Receta receta3 =new Receta("Gelatina","Facil","Primavera","1 paquete gelatina","Paso1 paso2, paso3, paso4");
        Ingrediente gelatina = new Ingrediente("Paquete Gelatina",1);
        Ingrediente agua = new Ingrediente ("Agua",500);
        receta3.addIngrediente(gelatina);
        receta3.addIngrediente(agua);
        Condimento condi1 = new Condimento("Condi1",200);
        Condimento condi2 = new Condimento ("Condi2",10);
        receta3.addCondimento(condi1);
        receta3.addCondimento(condi2);

        receta3.addCondicionPreexistente(new CondicionPreexistente("Vegano"));
        receta3.addCondicionPreexistente(new CondicionPreexistente("Hipertenso"));

        RepoRecetas.getInstance().agregarReceta(receta1);
        RepoRecetas.getInstance().agregarReceta(receta2);
        RepoRecetas.getInstance().agregarReceta(receta3);

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
