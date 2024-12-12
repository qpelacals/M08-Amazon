package com.example.m08_amazon;

// Imports necesarios
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ProductActivity extends AppCompatActivity { // Extiende AppCompatActivity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product); // Vincula el layout con esta actividad

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

        // Obtén los datos pasados por el Intent
        Intent intent = getIntent();
        int productImageResId = intent.getIntExtra("productImage", 0); // Imagen del producto
        String productTitle = intent.getStringExtra("productTitle"); // Título del producto
        String productDescription = intent.getStringExtra("productDescription"); // Descripción
        String productPrice = intent.getStringExtra("productPrice"); // Precio

        // Vincula los datos con las vistas
        ImageView productImage = findViewById(R.id.product_image);
        TextView title = findViewById(R.id.product_title);
        TextView description = findViewById(R.id.product_description);
        TextView price = findViewById(R.id.product_price);

        // Configura las vistas con los datos del Intent
        productImage.setImageResource(productImageResId);
        title.setText(productTitle);
        description.setText(productDescription);
        price.setText(productPrice);

        // Configura el botón de compra
        Button buyButton = findViewById(R.id.btn_buy);
        buyButton.setOnClickListener(view -> {
            // Crear Intent para ir a Confirmation
            Intent confirmationIntent = new Intent(ProductActivity.this, Confirmation.class);

            // Pasar datos del producto al Confirmation
            confirmationIntent.putExtra("productTitle", productTitle);
            confirmationIntent.putExtra("productPrice", productPrice);
            confirmationIntent.putExtra("USER_NAME", userName);

            // Iniciar la actividad Confirmation
            startActivity(confirmationIntent);
            finish(); // Finaliza la actividad actual para evitar volver atrás
        });
    }
}