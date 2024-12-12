package com.example.m08_amazon;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FooterFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflar el layout del fragmento
        View view = inflater.inflate(R.layout.fragment_footer, container, false);

        // Configurar el botón de home
        ImageButton homeButton = view.findViewById(R.id.home_button);
        homeButton.setOnClickListener(v -> {
            // Redirigir a HomeActivity
            Intent intent = new Intent(getActivity(), Home.class);
            startActivity(intent);
        });

        return view;
    }
}
