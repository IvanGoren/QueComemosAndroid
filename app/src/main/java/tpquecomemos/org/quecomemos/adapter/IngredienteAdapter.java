package tpquecomemos.org.quecomemos.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import tpquecomemos.org.quecomemos.R;
import tpquecomemos.org.quecomemos.domain.Ingrediente;

/**
 * Created by Ivan on 19/11/2015.
 */
public class IngredienteAdapter extends ArrayAdapter<Ingrediente> {

    public IngredienteAdapter(Context context, List<Ingrediente> ingredientes) {
        super(context, R.layout.ingrediente_row, ingredientes);
        Log.w("Recetas,",ingredientes.toString() );
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.ingrediente_row, parent, false);
        final Ingrediente ingrediente = getItem(position);

        TextView tvNombre = (TextView) rowView.findViewById(R.id.lblNombreIngrediente);
        tvNombre.setText(ingrediente.getNombreIngrediente());

        TextView tvCantidad = (TextView) rowView.findViewById(R.id.lblCantidad);
        tvCantidad.setText("" + ingrediente.getCantidad());
        return rowView;
    }
}

