package com.example.carrito.Belleza;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.carrito.R;

import java.util.ArrayList;
import java.util.List;

public class Belleza extends AppCompatActivity {

    TextView tvCantProductos;
    Button btnVerCarro;
    RecyclerView rvListaProductos;
    AdaptadorProductosBelleza adaptador;

    List<ProductoBelleza> listaProductoBellezas = new ArrayList<>();
    List<ProductoBelleza> carroCompras = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_belleza);
        getSupportActionBar().hide();

        tvCantProductos = findViewById(R.id.tvCantProductos);
        btnVerCarro = findViewById(R.id.btnVerCarro);
        rvListaProductos = findViewById(R.id.rvListaProductos);
        rvListaProductos.setLayoutManager(new GridLayoutManager(Belleza.this, 1));

        listaProductoBellezas.add(new ProductoBelleza("1", "Lápiz labial rojo", "Descripcion del Producto 1", 50.0));
        listaProductoBellezas.add(new ProductoBelleza("2", "Máscara de pestañas", "Descripcion del Producto 2", 80.0));
        listaProductoBellezas.add(new ProductoBelleza("3", "Paleta de sombras", "Descripcion del Producto 3", 40.0));
        listaProductoBellezas.add(new ProductoBelleza("4", "Esmalte de uñas", "Descripcion del Producto 4", 20.0));
        listaProductoBellezas.add(new ProductoBelleza("5", "Polvo facial", "Descripcion del Producto 5", 56.0));
        listaProductoBellezas.add(new ProductoBelleza("6", "Loción corporal", "Descripcion del Producto 5", 56.0));
        listaProductoBellezas.add(new ProductoBelleza("7", "Perfume", "Descripcion del Producto 5", 56.0));
        listaProductoBellezas.add(new ProductoBelleza("8", "Crema hidratante", "Descripcion del Producto 5", 56.0));
        listaProductoBellezas.add(new ProductoBelleza("9", "Champú", "Descripcion del Producto 5", 56.0));
        listaProductoBellezas.add(new ProductoBelleza("10", "Acondicionador", "Descripcion del Producto 5", 56.0));

        adaptador = new AdaptadorProductosBelleza(Belleza.this, tvCantProductos, btnVerCarro, listaProductoBellezas, carroCompras);
        rvListaProductos.setAdapter(adaptador);
    }
}
