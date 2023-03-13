package com.example.carrito.Farmacia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carrito.R;

import java.util.List;

public class AdaptadorCarroComprasFarmacia extends RecyclerView.Adapter<AdaptadorCarroComprasFarmacia.ProductosViewHolder> {

    Context context;
    List<ProductoFarmacia> carroComprasFarmacia;
    TextView tvTotalFarmacia;
    double total = 0;

    public AdaptadorCarroComprasFarmacia(Context context, List<ProductoFarmacia> carroComprasFarmacia, TextView tvTotalFarmacia) {
        this.context = context;
        this.carroComprasFarmacia = carroComprasFarmacia;
        this.tvTotalFarmacia = tvTotalFarmacia;

        for(int i = 0; i < carroComprasFarmacia.size() ; i++) {
            total = total + Double.parseDouble(""+ carroComprasFarmacia.get(i).getPrecio());
        }

        tvTotalFarmacia.setText(""+total);

    }

    @NonNull
    @Override
    public ProductosViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_rv_carro_compras_farmacia, null, false);
        return new AdaptadorCarroComprasFarmacia.ProductosViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductosViewHolder productosViewHolder, final int i) {
        productosViewHolder.tvNomProductoFarmacia.setText(carroComprasFarmacia.get(i).getNomProducto());
        productosViewHolder.tvDescripcionFarmacia.setText(carroComprasFarmacia.get(i).getDescripcion());
        productosViewHolder.tvPrecioFarmacia.setText(""+ carroComprasFarmacia.get(i).getPrecio());

    }

    @Override
    public int getItemCount() {
        return carroComprasFarmacia.size();
    }

    public class ProductosViewHolder extends RecyclerView.ViewHolder {

        TextView tvNomProductoFarmacia, tvDescripcionFarmacia, tvPrecioFarmacia;

        public ProductosViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNomProductoFarmacia = itemView.findViewById(R.id.tvNomProductoFarmacia);
            tvDescripcionFarmacia = itemView.findViewById(R.id.tvDescripcionFarmacia);
            tvPrecioFarmacia = itemView.findViewById(R.id.tvPrecioFarmacia);
        }
    }
}
