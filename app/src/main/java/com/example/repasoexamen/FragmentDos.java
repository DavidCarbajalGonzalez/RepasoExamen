package com.example.repasoexamen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentDos extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dos, container, false);

        // Modificar el texto del fragmento
        TextView textView = view.findViewById(R.id.textoFragmentoDos);
        textView.setText("Este es el Fragment Dos");

        return view;
    }
}
