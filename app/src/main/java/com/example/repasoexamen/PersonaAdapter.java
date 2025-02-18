package com.example.repasoexamen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PersonaAdapter extends RecyclerView.Adapter<PersonaAdapter.ViewHolder> {

    private final List<Persona> listaPersonas;

    public PersonaAdapter(List<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_persona, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Persona persona = listaPersonas.get(position);
        holder.textoNombre.setText(persona.getNombre());
        holder.textoEdad.setText(String.valueOf(persona.getEdad()));
    }

    @Override
    public int getItemCount() {
        return listaPersonas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textoNombre, textoEdad;

        public ViewHolder(View itemView) {
            super(itemView);
            textoNombre = itemView.findViewById(R.id.textoNombre);
            textoEdad = itemView.findViewById(R.id.textoEdad);
        }
    }
}
