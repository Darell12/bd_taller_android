package com.example.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.agenda.db.DbHelper;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCrear = findViewById(R.id.btnCrear);

        Intent cambio = new Intent(this, NewActivity.class);

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbHelper dbHelper = new DbHelper(MainActivity.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                if (db != null) {
                    Toast.makeText(MainActivity.this, "BASE DE DATOS CREADA", Toast.LENGTH_SHORT).show();
                    startActivity(cambio);
                    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                }else{
                    Toast.makeText(MainActivity.this, "ERROR AL CREAR BASE DE DATOS", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}