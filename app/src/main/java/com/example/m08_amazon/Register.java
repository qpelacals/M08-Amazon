package com.example.m08_amazon;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register); // Asegúrate de que este es el nombre correcto del layout

        // Referencias a los campos de entrada
        EditText editName = findViewById(R.id.edit_name);
        EditText editEmail = findViewById(R.id.edit_email);
        EditText editPassword = findViewById(R.id.edit_password);
        EditText editConfirmPassword = findViewById(R.id.edit_confirm_password);
        Button btnRegister = findViewById(R.id.btn_register);

        // Listener para el botón de registrar
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener los valores de los campos
                String name = editName.getText().toString().trim();
                String email = editEmail.getText().toString().trim();
                String password = editPassword.getText().toString().trim();
                String confirmPassword = editConfirmPassword.getText().toString().trim();

                // Validar los datos
                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(email) ||
                        TextUtils.isEmpty(password) || TextUtils.isEmpty(confirmPassword)) {
                    Toast.makeText(Register.this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!password.equals(confirmPassword)) {
                    Toast.makeText(Register.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Redirigir a la HomeActivity pasando el nombre del usuario
                Intent intent = new Intent(Register.this, Home.class);
                intent.putExtra("USER_NAME", name); // Pasar el nombre como extra
                startActivity(intent);
                finish(); // Finalizar esta actividad
            }
        });
    }
}
