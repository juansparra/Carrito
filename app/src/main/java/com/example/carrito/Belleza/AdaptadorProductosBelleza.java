package com.example.carrito.Belleza;
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

public class AdaptadorProductosBelleza extends RecyclerView.Adapter<AdaptadorProductosBelleza.ProductosViewHolder> {

    Context context;
    TextView tvCantProductos;
    Button btnVerCarro;
    List<ProductoBelleza> listaProductoBellezas;
    List<ProductoBelleza> carroCompra;

    public AdaptadorProductosBelleza(Context context, TextView tvCantProductos, Button btnVerCarro, List<ProductoBelleza> listaProductoBellezas, List<ProductoBelleza> carroCompra) {
        this.context = context;
        this.tvCantProductos = tvCantProductos;
        this.btnVerCarro = btnVerCarro;
        this.listaProductoBellezas = listaProductoBellezas;
        this.carroCompra = carroCompra;
    }

    @NonNull
    @Override
    public ProductosViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_rv_productos_belleza, null, false);
        return new AdaptadorProductosBelleza.ProductosViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductosViewHolder productosViewHolder, @SuppressLint("RecyclerView") final int i) {
        productosViewHolder.tvNomProducto.setText(listaProductoBellezas.get(i).getNomProducto());
        productosViewHolder.tvDescripcion.setText(listaProductoBellezas.get(i).getDescripcion());
        productosViewHolder.tvPrecio.setText(""+ listaProductoBellezas.get(i).getPrecio());

        productosViewHolder.cbCarro.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(productosViewHolder.cbCarro.isChecked() == true) {
                    tvCantProductos.setText(""+(Integer.parseInt(tvCantProductos.getText().toString().trim()) + 1));
                    carroCompra.add(listaProductoBellezas.get(i));
                } else if(productosViewHolder.cbCarro.isChecked() == false) {
                    tvCantProductos.setText(""+(Integer.parseInt(tvCantProductos.getText().toString().trim()) - 1));
                    carroCompra.remove(listaProductoBellezas.get(i));
                }
            }
        });

        btnVerCarro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CarroCompraBelleza.class);
                intent.putExtra("CarroCompras", (Serializable) carroCompra);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaProductoBellezas.size();
    }

    public class ProductosViewHolder extends RecyclerView.ViewHolder {

        TextView tvNomProducto, tvDescripcion, tvPrecio;
        CheckBox cbCarro;

        public ProductosViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNomProducto = itemView.findViewById(R.id.tvNomProducto);
            tvDescripcion = itemView.findViewById(R.id.tvDescripcion);
            tvPrecio = itemView.findViewById(R.id.tvPrecio);
            cbCarro = itemView.findViewById(R.id.cbCarro);
        }
    }
}
