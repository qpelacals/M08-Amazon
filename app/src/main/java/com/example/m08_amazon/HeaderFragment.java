package com.example.m08_amazon;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HeaderFragment extends Fragment {

    private String userName;

    public HeaderFragment() {
        // Constructor vacío requerido para el sistema
    }

    public static HeaderFragment newInstance(String userName) {
        HeaderFragment fragment = new HeaderFragment();
        Bundle args = new Bundle();
        args.putString("USER_NAME", userName);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_header, container, false);

        // Recuperar el nombre del usuario desde los argumentos
        if (getArguments() != null) {
            userName = getArguments().getString("USER_NAME");
        }

        // Configurar el texto del usuario
        TextView userNameTextView = view.findViewById(R.id.user_name);
        userNameTextView.setText(userName != null ? userName : "Usuario");

        return view;
    }
}