package com.example.rofviv.uniapp;

import android.content.Context;
import android.graphics.Color;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorMaterias extends BaseAdapter {

    private String[] colores = {"#0094c6", "#0e9c2e", "#f86400", "#091a45", "#e9030f", "#0094c6", "#0e9c2e", "#f86400", "#091a45", "#e9030f"};
    private Context activity;
    private ArrayList<Materias> listaMateria;

    public AdaptadorMaterias(Context activity, ArrayList<Materias> listaMateria) {
        this.activity = activity;
        this.listaMateria = listaMateria;
    }

    @Override
    public int getCount() {
        return listaMateria.size();
    }

    @Override
    public Object getItem(int i) {
        return listaMateria.get(i);
    }

    @Override
    public long getItemId(int i) {
        return listaMateria.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        if (v == null) {
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.materia_layout, null);
        }

        LinearLayout celda = (LinearLayout) v.findViewById(R.id.celda_materia);
        celda.setBackgroundColor(Color.parseColor(colores[i]));

        Materias mat = listaMateria.get(i);

        TextView txtMateria = (TextView) v.findViewById(R.id.txtMateria);
        txtMateria.setText(mat.getMateria());

        TextView txtHorario = (TextView) v.findViewById(R.id.txtHorario);
        txtHorario.setText(mat.getDia_horario());

        TextView txtDocente = (TextView) v.findViewById(R.id.txtDocente);
        txtDocente.setText(mat.getDocente());

        TextView txtAula = (TextView) v.findViewById(R.id.txtAula);
        txtAula.setText(mat.getAula());

        return v;
    }
}
