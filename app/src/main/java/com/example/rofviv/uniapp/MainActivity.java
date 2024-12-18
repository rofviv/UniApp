package com.example.rofviv.uniapp;

import android.graphics.Color;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private String[] pestanas = {"Inicio", "Mision y Vision", "Autoridades", "Carreras", "Direccion", "Noticias"};
    String carrera;
    public static String id;
    public static String nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppBarLayout appbar = (AppBarLayout) findViewById(R.id.appbar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        Bundle parametro = getIntent().getExtras();
        if (parametro != null) {
            id = parametro.getString("id");
            nombre = parametro.getString("nombre");

            carrera = parametro.getString("carrera");
            cargarColorCarrera(appbar, toolbar, tabLayout);
            pestanas[0] = "Mi Perfil";
        }
        cargarPestanas(tabLayout);
    }

    private void cargarPestanas(TabLayout tabLayout) {
        for (int i = 0; i < pestanas.length; i++) {
            tabLayout.addTab(tabLayout.newTab().setText(pestanas[i]));
        }
    }

    private void cargarColorCarrera(AppBarLayout appbar, Toolbar toolbar, TabLayout tabLayout) {
        switch (carrera) {
            case "1": {
                appbar.setBackgroundColor(Color.parseColor("#0094c6"));
                toolbar.setBackgroundColor(Color.parseColor("#0094c6"));
                tabLayout.setBackgroundColor(Color.parseColor("#0094c6"));
                //Toast.makeText(this, "info", Toast.LENGTH_SHORT).show();
                break;
            }
            case "2": {
                /*appbar.setBackgroundColor(Color.parseColor("#f7fd00"));
                toolbar.setBackgroundColor(Color.parseColor("#f7fd00"));
                tabLayout.setBackgroundColor(Color.parseColor("#f7fd00"));*/
                break;
            }
            case "3": {
                appbar.setBackgroundColor(Color.parseColor("#0e9c2e"));
                toolbar.setBackgroundColor(Color.parseColor("#0e9c2e"));
                tabLayout.setBackgroundColor(Color.parseColor("#0e9c2e"));
                break;
            }
            case "4": {
                appbar.setBackgroundColor(Color.parseColor("#f86400"));
                toolbar.setBackgroundColor(Color.parseColor("#f86400"));
                tabLayout.setBackgroundColor(Color.parseColor("#f86400"));
                break;
            }
            default:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.acercade) {
            acercaDe().show();
            return true;
        } else if (id == R.id.salir) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: {
                    if (pestanas[0].equals("Inicio")) {
                        InicioFragment i = new InicioFragment();
                        return i;
                    } else {
                        PerfilFragment p = new PerfilFragment();
                        return p;
                    }
                }
                case 1: {
                    MisionVisionFragment m = new MisionVisionFragment();
                    return m;
                }
                case 2: {
                    AutoridadesFragment a = new AutoridadesFragment();
                    return a;
                }
                case 3: {
                    CarrerasFragment c = new CarrerasFragment();
                    return c;
                }
                case 4: {
                    DireccionFragment d = new DireccionFragment();
                    return d;
                }
                case 5: {
                    NoticiasFragment n = new NoticiasFragment();
                    return n;
                }
                default: {
                    return null;
                }
            }
        }

        @Override
        public int getCount() {
            return pestanas.length;
        }
    }

    public AlertDialog acercaDe() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        LayoutInflater inflater = this.getLayoutInflater();
        View v = inflater.inflate(R.layout.acercade_layout, null);
        builder.setView(v);
        final AlertDialog dialog = builder.create();
        Button btnVolver = (Button) v.findViewById(R.id.btnCerrar);

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });

        return dialog;
    }
}
