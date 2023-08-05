package com.example.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.agenda.db.DbContactos;

public class NewActivity extends AppCompatActivity {
    EditText txtNombre;
    EditText txtTelefono;
    EditText txtCorreo;

    Button btnGuardar;

    Button btnListar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        txtNombre = findViewById(R.id.txtnombre);
        txtTelefono = findViewById(R.id.txttelefono);
        txtCorreo = findViewById(R.id.txtcorreo);

        btnGuardar = findViewById(R.id.btnguardar);
        btnListar = findViewById(R.id.btnListar);

        Intent listar = new Intent(this, ListarContactosActivity.class);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbContactos dbContactos = new DbContactos(NewActivity.this);
                long id = dbContactos.insertarContacto(txtNombre.getText().toString(), txtTelefono.getText().toString(), txtCorreo.getText().toString());
                if (id > 0) {
                    Toast.makeText(NewActivity.this, "Registro Guardado", Toast.LENGTH_SHORT).show();
                    limpiar();
                } else {
                    Toast.makeText(NewActivity.this, "Error al Guardar", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(listar);
            }
        });



    }

    private void limpiar() {
    txtNombre.setText("");
    txtTelefono.setText("");
    txtCorreo.setText("");
    }
}