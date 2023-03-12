package com.example.carrito.entity;

public class Producto {
    private String nombre;
    private String descripcion;
    private double precio;
    private int imagen;

    public Producto(String nombre, String descripcion, double precio, int imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public int getImagen() {
        return imagen;
    }
}
