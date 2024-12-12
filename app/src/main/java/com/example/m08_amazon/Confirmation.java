package com.example.m08_amazon;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Confirmation extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        // Obtener el nombre del usuario (puedes pasar esto dinámicamente desde el Intent)
        String userName = getIntent().getStringExtra("USER_NAME");

        // Crear e insertar el HeaderFragment
        HeaderFragment headerFragment = HeaderFragment.newInstance(userName);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.header_container, headerFragment)
                .commit();

        // Añadir el FooterFragment
        FooterFragment footerFragment = new FooterFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.footer_container, footerFragment)
                .commit();

        // Vincular vistas
        TextView confirmationMessage = findViewById(R.id.confirmation_message);
        TextView productDetails = findViewById(R.id.product_details);
        Button backToStoreButton = findViewById(R.id.back_to_store_button);

        // Obtener detalles del producto desde el Intent
        Intent intent = getIntent();
        String productTitle = intent.getStringExtra("productTitle");
        String productPrice = intent.getStringExtra("productPrice");

        // Configurar vistas
        confirmationMessage.setText(getString(R.string.confirmation_message));
        productDetails.setText(productTitle + " - " + productPrice);

        // Configurar acción del botón
        backToStoreButton.setOnClickListener(v -> {
            Intent backToHomeIntent = new Intent(Confirmation.this, Home.class);
            startActivity(backToHomeIntent);
            finish();
        });
    }
}
