package com.example.rofviv.uniapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class LoginActivity extends AppCompatActivity {

    Button btnEstudiante, btnInvitado;
    String id, nombre, carrera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnEstudiante = (Button) findViewById(R.id.inicio_btnEstudiante);
        btnInvitado = (Button) findViewById(R.id.inicio_btnInvitado);

        btnEstudiante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vistaLogin().show();
            }
        });
        btnInvitado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirMenuInvitado();
            }
        });

    }

    public AlertDialog vistaLogin() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        LayoutInflater inflater = this.getLayoutInflater();
        View v = inflater.inflate(R.layout.login_layout, null);
        builder.setView(v);

        final TextView txtRegistro = (TextView) v.findViewById(R.id.login_txtRegistro);
        final TextView txtClave = (TextView) v.findViewById(R.id.login_txtClave);

        Button btnIngresar = (Button) v.findViewById(R.id.login_btnIngresar);
        Button btnVolver = (Button) v.findViewById(R.id.login_btnVolver);

        final AlertDialog dialog = builder.create();

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!"".equals(txtRegistro.getText().toString()) && !"".equals(txtClave.getText().toString())) {
                    new IniciarSesion().execute(Conexion.ip + "login.php?r=" + txtRegistro.getText().toString() + "&c=" + txtClave.getText().toString());
                    dialog.dismiss();
                } else {
                    Toast.makeText(getApplicationContext(), "Tienes que llenar los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });

        return dialog;
    }

    public void abrirMenuEstudiante() {
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("id", this.id);
        i.putExtra("nombre", this.nombre);
        i.putExtra("carrera", this.carrera);
        startActivity(i);
    }

    private void abrirMenuInvitado() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    private class IniciarSesion extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            Toast.makeText(getApplicationContext() ,"Conectando...", Toast.LENGTH_SHORT).show();
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
                ja = new JSONArray(result);
                JSONObject jo = ja.getJSONObject(0);
                id = jo.getString("id");
                nombre = jo.getString("nombre");
                carrera = jo.getString("id_carrera");
                abrirMenuEstudiante();
            } catch (JSONException e) {
                Toast.makeText(getApplicationContext(), "Usuario incorrecto " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
