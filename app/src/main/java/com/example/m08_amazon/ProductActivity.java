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
            Toast.makeText(this, "Producto comprado: " + productTitle, Toast.LENGTH_SHORT).show();
        });
    }
}