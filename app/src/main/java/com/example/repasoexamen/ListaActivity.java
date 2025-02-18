package com.example.repasoexamen;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ListaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        // Array de nombres
        String[] nombres = {"Ana", "Juan", "Carlos", "María", "Sofía", "Pedro", "Luis"};

        // Obtener referencia del ListView
        ListView listView = findViewById(R.id.listView);

        // Crear y asignar un ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nombres);
        listView.setAdapter(adapter);

        // Evento de clic en un elemento de la lista
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String seleccionado = nombres[position];
                Toast.makeText(ListaActivity.this, "Seleccionaste: " + seleccionado, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
