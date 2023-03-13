package com.example.carrito.Farmacia;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carrito.R;

import java.util.List;

public class CarroCompraFarmacia extends AppCompatActivity {

    List<ProductoFarmacia> carroComprasFarmacia;

    AdaptadorCarroComprasFarmacia adaptadorCarroComprasFarmacia;

    RecyclerView rvListaCarroFarmacia;
    TextView tvTotalFarmacia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carro_compra_farmacia);
        getSupportActionBar().hide();

        carroComprasFarmacia = (List<ProductoFarmacia>) getIntent().getSerializableExtra("CarroCompras");

        rvListaCarroFarmacia = findViewById(R.id.rvListaCarroFarmacia);
        rvListaCarroFarmacia.setLayoutManager(new GridLayoutManager(CarroCompraFarmacia.this, 1));
        tvTotalFarmacia = findViewById(R.id.tvTotalFarmacia);

        adaptadorCarroComprasFarmacia = new AdaptadorCarroComprasFarmacia(CarroCompraFarmacia.this, carroComprasFarmacia, tvTotalFarmacia);
        rvListaCarroFarmacia.setAdapter(adaptadorCarroComprasFarmacia);

    }
}
