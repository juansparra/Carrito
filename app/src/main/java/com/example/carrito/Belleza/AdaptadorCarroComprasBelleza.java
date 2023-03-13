package com.example.carrito.Belleza;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carrito.R;

import java.util.List;

public class AdaptadorCarroComprasBelleza extends RecyclerView.Adapter<AdaptadorCarroComprasBelleza.ProductosViewHolder> {

    Context context;
    List<ProductoBelleza> carroCompra;
    TextView tvTotal;
    double total = 0;

    public AdaptadorCarroComprasBelleza(Context context, List<ProductoBelleza> carroCompra, TextView tvTotal) {
        this.context = context;
        this.carroCompra = carroCompra;
        this.tvTotal = tvTotal;

        for(int i = 0 ; i < carroCompra.size() ; i++) {
            total = total + Double.parseDouble(""+carroCompra.get(i).getPrecio());
        }

        tvTotal.setText(""+total);

    }

    @NonNull
    @Override
    public ProductosViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_rv_carro_compras_belleza, null, false);
        return new AdaptadorCarroComprasBelleza.ProductosViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductosViewHolder productosViewHolder, final int i) {
        productosViewHolder.tvNomProducto.setText(carroCompra.get(i).getNomProducto());
        productosViewHolder.tvDescripcion.setText(carroCompra.get(i).getDescripcion());
        productosViewHolder.tvPrecio.setText(""+carroCompra.get(i).getPrecio());

    }

    @Override
    public int getItemCount() {
        return carroCompra.size();
    }

    public class ProductosViewHolder extends RecyclerView.ViewHolder {

        TextView tvNomProducto, tvDescripcion, tvPrecio;

        public ProductosViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNomProducto = itemView.findViewById(R.id.tvNomProducto);
            tvDescripcion = itemView.findViewById(R.id.tvDescripcion);
            tvPrecio = itemView.findViewById(R.id.tvPrecio);
        }
    }
}
