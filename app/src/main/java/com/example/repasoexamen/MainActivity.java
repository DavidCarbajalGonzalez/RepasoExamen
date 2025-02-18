package com.example.repasoexamen;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Botón para abrir ListaActivity
        Button btnIrALista = findViewById(R.id.btn_ir_a_lista);
        btnIrALista.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ListaActivity.class);
            startActivity(intent);
        });

        // Botón para abrir SQLiteActivity
        Button btnIrASQLite = findViewById(R.id.btn_ir_a_sqlite);
        btnIrASQLite.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SQLiteActivity.class);
            startActivity(intent);
        });

        // Botón para cargar Fragment Uno
        Button btnFragmentUno = findViewById(R.id.btn_fragment_uno);
        btnFragmentUno.setOnClickListener(v -> cargarFragment(new FragmentUno()));

        // Botón para cargar Fragment Dos
        Button btnFragmentDos = findViewById(R.id.btn_fragment_dos);
        btnFragmentDos.setOnClickListener(v -> cargarFragment(new FragmentDos()));
    }

    // Método para cambiar los Fragments
    private void cargarFragment(androidx.fragment.app.Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}



