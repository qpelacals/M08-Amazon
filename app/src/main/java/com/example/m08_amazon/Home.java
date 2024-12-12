package com.example.m08_amazon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home); // Vincular el layout XML

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

        // Vincular los contenedores de productos
        LinearLayout product1 = findViewById(R.id.product1);
        LinearLayout product2 = findViewById(R.id.product2);
        LinearLayout product3 = findViewById(R.id.product3);
        LinearLayout product4 = findViewById(R.id.product4);

        // Configurar clics en cada producto para redirigir al ProductActivity con datos específicos
        product1.setOnClickListener(v -> openProductActivity(
                R.drawable.jamon,
                "Jamón de Bellota",
                "Jamón ibérico de bellota, curado durante 36 meses para un sabor inigualable.",
                "$149.99",
                userName
        ));

        product2.setOnClickListener(v -> openProductActivity(
                R.drawable.play5,
                "PlayStation 5",
                "La consola de nueva generación de Sony con gráficos impresionantes.",
                "$499.99",
                userName
        ));

        product3.setOnClickListener(v -> openProductActivity(
                R.drawable.taladro,
                "Taladro Percutor Kit",
                "Taladro percutor profesional con varios accesorios, ideal para bricolaje.",
                "$79.99",
                userName
        ));

        product4.setOnClickListener(v -> openProductActivity(
                R.drawable.cafetera,
                "Cafetera OSTER BVSTEM7400",
                "Cafetera espresso automática de alta calidad, ideal para el hogar.",
                "$99.99",
                userName
        ));
    }

    // Método para abrir ProductActivity con los datos del producto
    private void openProductActivity(int imageResId, String title, String description, String price, String userName) {
        Intent intent = new Intent(this, ProductActivity.class);
        intent.putExtra("productImage", imageResId);
        intent.putExtra("productTitle", title);
        intent.putExtra("productDescription", description);
        intent.putExtra("productPrice", price);
        intent.putExtra("USER_NAME", userName);
        startActivity(intent);
    }
}
