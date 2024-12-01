package com.example.m08_amazon;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnLogin, btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar botones
        btnLogin = findViewById(R.id.btn_login_main);
        btnRegister = findViewById(R.id.btn_register_main);

        // Manejar clic en Iniciar Sesión
        btnLogin.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, authapp.AuthActivity.class);
            intent.putExtra("auth_mode", "login");
            startActivity(intent);
        });

        // Manejar clic en Registrarse
        btnRegister.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, authapp.AuthActivity.class);
            intent.putExtra("auth_mode", "register");
            startActivity(intent);
        });
    }
}
