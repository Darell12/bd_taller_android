package com.example.agenda.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.agenda.models.Contacto;

import java.util.ArrayList;
import java.util.List;

public class DbContactos extends DbHelper {

    Context context;


    public DbContactos(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public List<Contacto> listarContactos() {
        List<Contacto> contactos = new ArrayList<>();
        try {
            SQLiteDatabase db = getReadableDatabase();
            String[] projection = {"id", "nombre", "telefono", "correo"};
            Cursor cursor = db.query(TABLE_CONTACTO, projection, null, null, null, null, null);

            while (cursor.moveToNext()) {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String nombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre"));
                String telefono = cursor.getString(cursor.getColumnIndexOrThrow("telefono"));
                String correo = cursor.getString(cursor.getColumnIndexOrThrow("correo"));

                Contacto contacto = new Contacto();

                contacto.setId(id);
                contacto.setNombre(nombre);
                contacto.setTelefono(telefono);
                contacto.setCorreo(correo);

                contactos.add(contacto);
            }

            cursor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contactos;
    }

    public long insertarContacto(String nombre, String telefono, String correo){
        long id = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("nombre", nombre);
            values.put("telefono", telefono);
            values.put("correo", correo);
            id = db.insert(TABLE_CONTACTO, null, values);
        } catch (Exception e) {
            e.toString();
        }
        return id;
    }

    public Contacto verContacto(int id){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Contacto> listaContacto = new ArrayList<>();
        Contacto contacto = null;
        Cursor cursorContacto = null;

    cursorContacto = db.rawQuery("SELECT * FROM " + TABLE_CONTACTO + " WHERE id = " + id + " LIMIT 1", null);

        if (cursorContacto.moveToFirst()) {
            contacto = new Contacto();
            contacto.setId(cursorContacto.getInt(0));
            contacto.setNombre(cursorContacto.getString(1));
            contacto.setTelefono(cursorContacto.getString(2));
            contacto.setCorreo(cursorContacto.getString(3));
        }
        cursorContacto.close();
        return contacto;
    }
}
