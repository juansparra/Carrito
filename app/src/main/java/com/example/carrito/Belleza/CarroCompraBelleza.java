package com.example.carrito.Belleza;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carrito.R;

import java.util.List;

public class CarroCompraBelleza extends AppCompatActivity {

    List<ProductoBelleza> carroCompras;

    AdaptadorCarroComprasBelleza adaptador;

    RecyclerView rvListaCarro;
    TextView tvTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carro_compra_belleza);
        getSupportActionBar().hide();

        carroCompras = (List<ProductoBelleza>) getIntent().getSerializableExtra("CarroCompras");

        rvListaCarro = findViewById(R.id.rvListaCarro);
        rvListaCarro.setLayoutManager(new GridLayoutManager(CarroCompraBelleza.this, 1));
        tvTotal = findViewById(R.id.tvTotal);

        adaptador = new AdaptadorCarroComprasBelleza(CarroCompraBelleza.this, carroCompras, tvTotal);
        rvListaCarro.setAdapter(adaptador);

    }
}
