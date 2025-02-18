package com.example.repasoexamen;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class SQLiteActivity extends AppCompatActivity {

    private DatabaseHelper dbHelper;
    private EditText etNombre, etEdad, etEliminarId;
    private ListView listViewUsuarios;
    private Button btnAgregar, btnEliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        // Inicializar la base de datos
        dbHelper = new DatabaseHelper(this);

        // Referencias de UI
        etNombre = findViewById(R.id.et_nombre);
        etEdad = findViewById(R.id.et_edad);
        etEliminarId = findViewById(R.id.et_eliminar_id);
        btnAgregar = findViewById(R.id.btn_agregar);
        btnEliminar = findViewById(R.id.btn_eliminar);
        listViewUsuarios = findViewById(R.id.list_view_usuarios);

        //  Cargar la lista de usuarios automáticamente al abrir la actividad
        cargarUsuarios();

        // Botón para agregar usuario
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = etNombre.getText().toString();
                String edadStr = etEdad.getText().toString();

                if (!nombre.isEmpty() && !edadStr.isEmpty()) {
                    int edad = Integer.parseInt(edadStr);
                    boolean insertado = dbHelper.insertarUsuario(nombre, edad);
                    if (insertado) {
                        Toast.makeText(SQLiteActivity.this, "Usuario agregado", Toast.LENGTH_SHORT).show();
                        etNombre.setText("");
                        etEdad.setText("");
                        cargarUsuarios(); // Actualizar la lista después de agregar
                    } else {
                        Toast.makeText(SQLiteActivity.this, "Error al agregar usuario", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(SQLiteActivity.this, "Campos vacíos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Botón para eliminar usuario por ID
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idStr = etEliminarId.getText().toString();
                if (!idStr.isEmpty()) {
                    int id = Integer.parseInt(idStr);
                    boolean eliminado = dbHelper.eliminarUsuario(id);
                    if (eliminado) {
                        Toast.makeText(SQLiteActivity.this, "Usuario eliminado", Toast.LENGTH_SHORT).show();
                        etEliminarId.setText("");
                        cargarUsuarios(); // Actualizar la lista después de eliminar
                    } else {
                        Toast.makeText(SQLiteActivity.this, "Error al eliminar usuario", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(SQLiteActivity.this, "Ingrese un ID", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Método para cargar los usuarios desde la base de datos
    private void cargarUsuarios() {
        List<String> usuarios = dbHelper.obtenerUsuarios();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, usuarios);
        listViewUsuarios.setAdapter(adapter);
    }
}

