package com.example.carrito.Farmacia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.carrito.R;

import java.util.ArrayList;
import java.util.List;

public class Farmacia extends AppCompatActivity {
    TextView tvCantProductosFarmacia;
    Button btnVerCarroFarmacia;
    RecyclerView rvListaProductosFarmacia;
    AdaptadorProductosFarmacia adaptadorFarmacia;

    List<ProductoFarmacia> listaProductoFarmacias = new ArrayList<>();
    List<ProductoFarmacia> carroComprasFarmacia = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmacia);


        tvCantProductosFarmacia = findViewById(R.id.tvCantidadFarmacia);
        btnVerCarroFarmacia = findViewById(R.id.btnVerCarroFarmacia);
        rvListaProductosFarmacia = findViewById(R.id.rvListaProductosFarmacia);
        rvListaProductosFarmacia.setLayoutManager(new GridLayoutManager(Farmacia.this, 1));
        listaProductoFarmacias.add(new ProductoFarmacia("1", "Analgesia ", "Descripcion del Producto 1", 50.0));
        listaProductoFarmacias.add(new ProductoFarmacia("2", "Antiácido ", "Descripcion del Producto 2", 80.0));
        listaProductoFarmacias.add(new ProductoFarmacia("3", "Antialérgico ", "Descripcion del Producto 3", 40.0));
        listaProductoFarmacias.add(new ProductoFarmacia("4", "Antibiótico ", "Descripcion del Producto 4", 20.0));
        listaProductoFarmacias.add(new ProductoFarmacia("5", "Antiinflamatorio ", "Descripcion del Producto 5", 56.0));
        listaProductoFarmacias.add(new ProductoFarmacia("6", "Antimicótico ", "Descripcion del Producto 1", 50.0));
        listaProductoFarmacias.add(new ProductoFarmacia("7", "Antipirético ", "Descripcion del Producto 2", 80.0));
        listaProductoFarmacias.add(new ProductoFarmacia("8", "Antitusivo ", "Descripcion del Producto 3", 40.0));
        listaProductoFarmacias.add(new ProductoFarmacia("9", "Hidratante de labio ", "Descripcion del Producto 4", 20.0));
        listaProductoFarmacias.add(new ProductoFarmacia("10", "Protector solar ", "Descripcion del Producto 5", 56.0));

        adaptadorFarmacia = new AdaptadorProductosFarmacia(Farmacia.this, tvCantProductosFarmacia, btnVerCarroFarmacia, listaProductoFarmacias, carroComprasFarmacia);
        rvListaProductosFarmacia.setAdapter(adaptadorFarmacia);
    }
}