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
import tpquecomemos.org.quecomemos.domain.CondicionPreexistente;

/**
 * Created by hp on 22/11/2015.
 */
public class CondicionPreexistenteAdapter extends ArrayAdapter<CondicionPreexistente> {

    public CondicionPreexistenteAdapter(Context context, List<CondicionPreexistente> condiciones) {
        super(context, R.layout.condicion_preexistente_row, condiciones);
        Log.w("Recetas,", condiciones.toString());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.condicion_preexistente_row, parent, false);
        final CondicionPreexistente condicion = getItem(position);

        TextView tvNombre = (TextView) rowView.findViewById(R.id.lblNombreCondicion);
        tvNombre.setText(condicion.getNombreCondicion());
        return rowView;
    }

}
