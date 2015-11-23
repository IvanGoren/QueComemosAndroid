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
import tpquecomemos.org.quecomemos.domain.Condimento;
/**
 * Created by hp on 22/11/2015.
 */

public class CondimentoAdapter extends ArrayAdapter<Condimento>{

    public CondimentoAdapter(Context context, List<Condimento> condimentos) {
        super(context, R.layout.condimento_row, condimentos);
        Log.w("Recetas,", condimentos.toString());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.condimento_row, parent, false);
        final Condimento condimento = getItem(position);

        TextView tvNombre = (TextView) rowView.findViewById(R.id.lblNombreIngrediente);
        tvNombre.setText(condimento.getNombreCondimento());

        TextView tvCantidad = (TextView) rowView.findViewById(R.id.lblCantidad);
        tvCantidad.setText("" + condimento.getCantidad());
        return rowView;
    }

}
