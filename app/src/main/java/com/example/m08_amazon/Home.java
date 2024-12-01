package com.example.m08_amazon;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    private EditText searchBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Inicialización del buscador
        searchBar = findViewById(R.id.search_bar);

        // Productos clicables
        @SuppressLint("WrongViewCast") ImageButton product1 = findViewById(R.id.product1);
        ImageButton product2 = findViewById(R.id.product2);
        ImageButton product3 = findViewById(R.id.product3);
        ImageButton product4 = findViewById(R.id.product4);

        // Evento de clic para cada producto
        product1.setOnClickListener(v -> openProductDetail("Producto 1"));
        product2.setOnClickListener(v -> openProductDetail("Producto 2"));
        product3.setOnClickListener(v -> openProductDetail("Producto 3"));
        product4.setOnClickListener(v -> openProductDetail("Producto 4"));
    }

    // Método para abrir la pantalla de detalle del producto
    private void openProductDetail(String productName) {
        Intent intent = new Intent(HomeActivity.this, ProductDetailActivity.class);
        intent.putExtra("PRODUCT_NAME", productName);
        startActivity(intent);
    }
}