package tpquecomemos.org.quecomemos.service;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import tpquecomemos.org.quecomemos.domain.Receta;

/**
 * Created by hp on 23/11/2015.
 */
public interface RecetaService {

//        @GET("receta/{id}")
//        public Call<List<Receta>> getReceta(@Path("id") String id);


        @GET("recetas")
        public Call<List<Receta>> getRecetas();

    }

