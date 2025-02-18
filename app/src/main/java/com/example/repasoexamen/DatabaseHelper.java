package com.example.repasoexamen;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Nombre de la base de datos y versión
    private static final String DATABASE_NAME = "usuarios.db";
    private static final int DATABASE_VERSION = 1;

    // Nombre de la tabla y columnas
    private static final String TABLE_USUARIOS = "usuarios";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NOMBRE = "nombre";
    private static final String COLUMN_EDAD = "edad";

    // Sentencia SQL para crear la tabla
    private static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_USUARIOS + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NOMBRE + " TEXT NOT NULL, " +
                    COLUMN_EDAD + " INTEGER NOT NULL)";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USUARIOS);
        onCreate(db);
    }

    // Método para insertar un usuario
    public boolean insertarUsuario(String nombre, int edad) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NOMBRE, nombre);
        values.put(COLUMN_EDAD, edad);

        long resultado = db.insert(TABLE_USUARIOS, null, values);
        return resultado != -1; // Devuelve true si se insertó correctamente
    }

    // Método para obtener todos los usuarios
    public List<String> obtenerUsuarios() {
        List<String> listaUsuarios = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_USUARIOS, null);

        if (cursor.moveToFirst()) {
            do {
                String usuario = "ID: " + cursor.getInt(0) +
                        " | Nombre: " + cursor.getString(1) +
                        " | Edad: " + cursor.getInt(2);
                listaUsuarios.add(usuario);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return listaUsuarios;
    }

    // Método para eliminar un usuario por ID
    public boolean eliminarUsuario(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_USUARIOS, COLUMN_ID + "=?", new String[]{String.valueOf(id)}) > 0;
    }
}
