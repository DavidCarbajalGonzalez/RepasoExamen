package com.example.repasoexamen;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        // Lista de datos
        List<Persona> listaPersonas = new ArrayList<>();
        listaPersonas.add(new Persona("Ana", 25));
        listaPersonas.add(new Persona("Juan", 30));
        listaPersonas.add(new Persona("Carlos", 28));
        listaPersonas.add(new Persona("María", 22));

        // Configurar RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Asignar adaptador
        PersonaAdapter adapter = new PersonaAdapter(listaPersonas);
        recyclerView.setAdapter(adapter);
    }
}

