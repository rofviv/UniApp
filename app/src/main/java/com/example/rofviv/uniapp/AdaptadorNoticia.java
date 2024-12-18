package com.example.rofviv.uniapp;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorNoticia extends BaseAdapter{

    private String[] colores = {"#091a45", "#f86400", "#0094c6", "#0e9c2e", "#e9030f", "#0094c6", "#0e9c2e", "#f86400", "#091a45", "#e9030f"};
    private Context activity;
    private ArrayList<Noticia> listaNoticia;

    public AdaptadorNoticia(Context activity, ArrayList<Noticia> listaNoticia) {
        this.activity = activity;
        this.listaNoticia = listaNoticia;
    }

    @Override
    public int getCount() {
        return listaNoticia.size();
    }

    @Override
    public Object getItem(int i) {
        return listaNoticia.get(i);
    }

    @Override
    public long getItemId(int i) {
        return listaNoticia.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        if (v == null) {
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.noticia_layout, null);
        }

        LinearLayout celda = (LinearLayout) v.findViewById(R.id.noticia_celda);
        celda.setBackgroundColor(Color.parseColor(colores[i]));

        Noticia mat = listaNoticia.get(i);

        TextView txtNoticia= (TextView) v.findViewById(R.id.tituloNoticia);
        txtNoticia.setText(mat.getTitulo());

        TextView txtdescr = (TextView) v.findViewById(R.id.descripcionN);
        txtdescr.setText(mat.getDescripcion());

        TextView textFec = (TextView) v.findViewById(R.id.fechaN);
        textFec.setText(mat.getFecha());

        ImageView img = (ImageView) v.findViewById(R.id.imangenN);
        img.setImageResource(mat.getImagen());

        return v;
    }
}
