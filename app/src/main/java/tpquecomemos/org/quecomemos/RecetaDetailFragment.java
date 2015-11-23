package tpquecomemos.org.quecomemos;

import android.app.Activity;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import tpquecomemos.org.quecomemos.adapter.CondicionPreexistenteAdapter;
import tpquecomemos.org.quecomemos.adapter.CondimentoAdapter;
import tpquecomemos.org.quecomemos.adapter.IngredienteAdapter;
import tpquecomemos.org.quecomemos.domain.Receta;
import tpquecomemos.org.quecomemos.repo.RepoRecetas;

/**
 * A fragment representing a single Receta detail screen.
 * This fragment is either contained in a {@link RecetaListActivity}
 * in two-pane mode (on tablets) or a {@link RecetaDetailActivity}
 * on handsets.
 */
public class RecetaDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private Receta receta;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public RecetaDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            String idReceta= getArguments().getString(ARG_ITEM_ID);
            receta = RepoRecetas.getInstance().getReceta(new Long(idReceta).longValue());

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(receta.getNombre());
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.receta_detail_fragment, container, false);
        if (receta != null) {
            ((ListView) rootView.findViewById(R.id.list_ingredientes))
                    .setAdapter(
                            new IngredienteAdapter(getActivity(),
                                    receta.getIngredientesList()
                            )
                    );

            ((ListView) rootView.findViewById(R.id.list_condimentos))
                    .setAdapter(
                            new CondimentoAdapter(getActivity(),
                                    receta.getCondimentosList()
                            )
                    );

            ((ListView) rootView.findViewById(R.id.list_condiciones_preexistentes))
                    .setAdapter(
                            new CondicionPreexistenteAdapter(getActivity(),
                                    receta.getCondicionesPreexistentesList()
                            )
                    );

            ((TextView) rootView.findViewById(R.id.receta_dificultad)).setText(receta.getDificultad());
            ((TextView) rootView.findViewById(R.id.receta_temporada)).setText(receta.getTemporada());
            ((TextView) rootView.findViewById(R.id.receta_ingredientes)).setText(receta.getIngredientes());
            ((TextView) rootView.findViewById(R.id.receta_isntrucciones)).setText(receta.getInstrucciones());
        }

        return rootView;
    }
}
