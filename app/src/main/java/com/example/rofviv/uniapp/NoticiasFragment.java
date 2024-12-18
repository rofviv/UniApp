package com.example.rofviv.uniapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class NoticiasFragment extends Fragment {

    ListView lstNoticia;
    ArrayList<Noticia> arrayNoticia;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_noticias, container, false);
        lstNoticia = (ListView) v.findViewById(R.id.lstNoticia);
        cargarLista();

        return v;
    }

    private void cargarLista() {
        arrayNoticia = new ArrayList<Noticia>();
        AdaptadorNoticia adaptador;

        arrayNoticia.add(new Noticia(1, R.drawable.logo_app, "UniApp", "La aplicacion para el Unibethsitario estara presentandose en la Feria Cientifica 2018", "22/06/2018"));
        arrayNoticia.add(new Noticia(2, R.drawable.logo_login, "Feria Cientifica 2018", "Este viernes 22 de junio será la feria cientifica Unibeth, no te lo pierdas", "21/06/2018"));
        arrayNoticia.add(new Noticia(3, R.drawable.logo_iniciov2, "Becas de 75%", "Informate en nuestras oficinas de como obtener tu beca del 75%", "20/06/2018"));
        //arrayNoticia.add(new Noticia(4, R.drawable.logo_app_agua, "Juegos Universitarios", "Practicas algun deporte? No olvides inscribirte para participar muy pronto en los juegos universitarios", "20/06/2018"));

        adaptador = new AdaptadorNoticia(getContext(), arrayNoticia);
        lstNoticia.setAdapter(adaptador);
    }
}
