package com.example.m08_amazon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login); // Asegúrate de que el nombre del layout sea correcto

        // Obtener la referencia al TextView
        TextView txtRegister = findViewById(R.id.txt_register);

        // Configurar el listener para redirigir a la actividad Register
        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Crear un intent para ir a la actividad Register
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });
    }
}