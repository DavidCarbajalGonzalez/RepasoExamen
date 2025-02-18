package com.example.repasoexamen;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class ListaActivity extends AppCompatActivity {

    private String[] nombres = {"Ana", "Juan", "Carlos", "María", "Sofía", "Pedro", "Luis"};
    private int[] edades = {25, 30, 28, 22, 27, 35, 40}; // Edades asociadas a los nombres

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        // Obtener referencia del ListView
        ListView listView = findViewById(R.id.listView);

        // Crear y asignar un ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nombres);
        listView.setAdapter(adapter);

        // Evento de clic en un elemento de la lista para mostrar el diálogo
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mostrarDialogo(nombres[position], edades[position]); // Mostrar diálogo con datos
            }
        });
    }


    // Método para mostrar el diálogo con los datos de la persona seleccionada
    private void mostrarDialogo(String nombre, int edad) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Detalles de la Persona");
        builder.setMessage("Nombre: " + nombre + "\nEdad: " + edad + " años");
        builder.setPositiveButton("Cerrar", null);
        builder.show();
    }
}

