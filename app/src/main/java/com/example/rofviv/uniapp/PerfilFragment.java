package com.example.rofviv.uniapp;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class PerfilFragment extends Fragment {

    ListView lstMaterias;
    ArrayList<Materias> arrayMaterias;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        lstMaterias = (ListView) v.findViewById(R.id.lstMaterias);
        TextView txtSaludo = (TextView) v.findViewById(R.id.txtBienvenido);
        txtSaludo.setText("Bienvenido " + MainActivity.nombre);
        //cargarLista();
        new cargarMaterias().execute(Conexion.ip + "lista.php?id=" + MainActivity.id);
        return v;
    }

    private void cargarLista() {
        arrayMaterias = new ArrayList<Materias>();
        AdaptadorMaterias adaptadorMaterias;

        arrayMaterias.add(new Materias(2, "Taller de Grado", "NA", "7", "Ing. Edgar Gomez", "Lunes y Miercoles 18 a 21 horas", "#112 - Central"));
        arrayMaterias.add(new Materias(1, "Sistemas Expertos", "NA", "7", "Ing. Juan Jose", "Martes y Jueves 18 a 21 horas", "#109 - Central"));

        adaptadorMaterias = new AdaptadorMaterias(getContext(), arrayMaterias);
        lstMaterias.setAdapter(adaptadorMaterias);
    }

    private class cargarMaterias extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            //Toast.makeText(getApplicationContext() ,"Conectando...", Toast.LENGTH_SHORT).show();
            //etUsuario.setEnabled(false);
        }

        @Override
        protected String doInBackground(String... urls) {
            try {
                return Funciones.downloadUrl(urls[0]);
            } catch (IOException e) {
                return "Pagina web deshabilitada. URL Invalida";
            }
        }

        @Override
        protected void onPostExecute(String result) {
            JSONArray ja = null;
            try {
                arrayMaterias = new ArrayList<Materias>();
                AdaptadorMaterias adaptadorMaterias;
                ja = new JSONArray(result);
                JSONObject jo = ja.getJSONObject(0);
                for (int i = 0; i < ja.length(); i++) {
                    jo = ja.getJSONObject(i);
                    arrayMaterias.add(new Materias(Integer.parseInt(jo.getString("id")), jo.getString("materia"), "descripcion", "semestre", jo.getString("docente"), jo.getString("horario"), jo.getString("aula")));
                }
                adaptadorMaterias = new AdaptadorMaterias(getContext(), arrayMaterias);
                lstMaterias.setAdapter(adaptadorMaterias);

            } catch (JSONException e) {
                //Toast.makeText(getContext(), "Usuario incorrecto " + e.getMessage(), Toast.LENGTH_SHORT).show();
                Log.w("LISTA", e.getMessage());
            }
        }
    }
}
