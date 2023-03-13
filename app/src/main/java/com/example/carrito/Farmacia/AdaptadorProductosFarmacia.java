package com.example.carrito.Farmacia;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carrito.R;

import java.io.Serializable;
import java.util.List;

public class AdaptadorProductosFarmacia extends RecyclerView.Adapter<AdaptadorProductosFarmacia.ProductosViewHolder> {

    Context context;
    TextView tvCantProductosFarmacia;
    Button btnVerCarroFarmacia;
    List<ProductoFarmacia> listaProductoFarmacias;
    List<ProductoFarmacia> carroCompraFarmacia;

    public AdaptadorProductosFarmacia(Context context, TextView tvCantProductosFarmacia, Button btnVerCarroFarmacia, List<ProductoFarmacia> listaProductoFarmacias, List<ProductoFarmacia> carroCompraFarmacia) {
        this.context = context;
        this.tvCantProductosFarmacia = tvCantProductosFarmacia;
        this.btnVerCarroFarmacia = btnVerCarroFarmacia;
        this.listaProductoFarmacias = listaProductoFarmacias;
        this.carroCompraFarmacia = carroCompraFarmacia;
    }

    @NonNull
    @Override
    public ProductosViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_rv_productos_farmacia, null, false);
        return new AdaptadorProductosFarmacia.ProductosViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductosViewHolder productosViewHolder, @SuppressLint("RecyclerView") final int i) {
        productosViewHolder.tvNomProductoFarmacia.setText(listaProductoFarmacias.get(i).getNomProducto());
        productosViewHolder.tvDescripcionFarmacia.setText(listaProductoFarmacias.get(i).getDescripcion());
        productosViewHolder.tvPrecioFarmacia.setText(""+ listaProductoFarmacias.get(i).getPrecio());

        productosViewHolder.cbCarroFarmacia.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(productosViewHolder.cbCarroFarmacia.isChecked() == true) {
                    tvCantProductosFarmacia.setText(""+(Integer.parseInt(tvCantProductosFarmacia.getText().toString().trim()) + 1));
                    carroCompraFarmacia.add(listaProductoFarmacias.get(i));
                } else if(productosViewHolder.cbCarroFarmacia.isChecked() == false) {
                    tvCantProductosFarmacia.setText(""+(Integer.parseInt(tvCantProductosFarmacia.getText().toString().trim()) - 1));
                    carroCompraFarmacia.remove(listaProductoFarmacias.get(i));
                }
            }
        });

        btnVerCarroFarmacia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CarroCompraFarmacia.class);
                intent.putExtra("CarroCompras", (Serializable) carroCompraFarmacia);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaProductoFarmacias.size();
    }

    public class ProductosViewHolder extends RecyclerView.ViewHolder {

        TextView tvNomProductoFarmacia, tvDescripcionFarmacia, tvPrecioFarmacia;
        CheckBox cbCarroFarmacia;

        public ProductosViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNomProductoFarmacia = itemView.findViewById(R.id.tvNomProductoFarmacia);
            tvDescripcionFarmacia = itemView.findViewById(R.id.tvDescripcionFarmacia);
            tvPrecioFarmacia = itemView.findViewById(R.id.tvPrecioFarmacia);
            cbCarroFarmacia = itemView.findViewById(R.id.cbCarroFarmacia);
        }
    }
}
