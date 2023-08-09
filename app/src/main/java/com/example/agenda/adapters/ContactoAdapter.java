package com.example.agenda.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agenda.R;
import com.example.agenda.VerActivity;
import com.example.agenda.models.Contacto;
import java.util.List;

public class ContactoAdapter extends RecyclerView.Adapter<ContactoAdapter.ContactoViewHolder> {

    private static List<Contacto> contactos;

    public ContactoAdapter(List<Contacto> contactos) {
        this.contactos = contactos;
    }

    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_contacto, parent, false);
        return new ContactoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder holder, int position) {
        Contacto contacto = contactos.get(position);
        holder.textNombre.setText(contacto.getNombre());
        holder.textTelefono.setText(contacto.getTelefono());
        holder.textCorreo.setText(contacto.getCorreo());
    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder {
        TextView textNombre, textTelefono, textCorreo;

        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            textNombre = itemView.findViewById(R.id.text_nombre);
            textTelefono = itemView.findViewById(R.id.text_telefono);
            textCorreo = itemView.findViewById(R.id.text_correo);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = itemView.findViewById(R.id.text_nombre).getContext();
                    Intent intent = new Intent(context, VerActivity.class);
                    intent.putExtra("ID", contactos.get(getAdapterPosition()).getId());
                    context.startActivity(intent);
                }
            });
        }
    }
}
