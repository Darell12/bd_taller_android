package com.example.agenda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.agenda.adapters.ContactoAdapter;
import com.example.agenda.db.DbContactos;
import com.example.agenda.models.Contacto;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class ListarContactosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_contactos);

        Button btnAgregar = findViewById(R.id.btnAgregar);

        // Dentro de tu MainActivity.java
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        DbContactos dbContactos = new DbContactos(this);
        List<Contacto> contactos = dbContactos.listarContactos();

        ContactoAdapter adapter = new ContactoAdapter(contactos);
        recyclerView.setAdapter(adapter);

        Intent agregar = new Intent(this, NewActivity.class);
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(agregar);
            }
        });
    }
}