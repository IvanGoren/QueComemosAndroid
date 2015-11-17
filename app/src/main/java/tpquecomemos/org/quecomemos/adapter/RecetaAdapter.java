package tpquecomemos.org.quecomemos.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import tpquecomemos.org.quecomemos.R;
import tpquecomemos.org.quecomemos.domain.Receta;

/**
 * Created by Ivan on 17/11/2015.
 */
public class RecetaAdapter extends ArrayAdapter<Receta> {

    public RecetaAdapter(Context context, List<Receta> recetas) {
        super(context, R.layout.receta_row, recetas);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.receta_row, parent, false);
        final Receta receta = getItem(position);

        TextView tvNombre = (TextView) rowView.findViewById(R.id.lblNombre);
        tvNombre.setText(receta.toString());

        TextView tvDificultad = (TextView) rowView.findViewById(R.id.lblDificultad);
        tvDificultad.setText(receta.getDificultad());
        return rowView;
    }
}
