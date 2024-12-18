package com.example.rofviv.uniapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class CarrerasFragment extends Fragment {

    Button btnInfo, btnTeo, btnTra, btnCom;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_carreras, container, false);
        btnInfo = (Button) v.findViewById(R.id.carreras_ing);
        btnCom = (Button) v.findViewById(R.id.carreras_com);
        btnTeo = (Button) v.findViewById(R.id.carreras_teo);
        btnTra = (Button) v.findViewById(R.id.carreras_tra);

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                infoCarrera("Ingeniería Informática").show();
            }
        });

        btnTeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                infoCarrera("Teología").show();
            }
        });

        btnTra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                infoCarrera("Trabajo Social").show();
            }
        });

        btnCom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                infoCarrera("Comunicación Social").show();
            }
        });

        return v;
    }

    public AlertDialog infoCarrera(String carrera) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        LayoutInflater inflater = this.getLayoutInflater();
        View v = inflater.inflate(R.layout.info_carrera_layout, null);
        builder.setView(v);

        TextView txcarrera = (TextView) v.findViewById(R.id.txtCarrera);
        txcarrera.setText(carrera);

        Button btnVolver = (Button) v.findViewById(R.id.btnCerrarInfo);

        final AlertDialog dialog = builder.create();

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });

        return dialog;
    }
}
