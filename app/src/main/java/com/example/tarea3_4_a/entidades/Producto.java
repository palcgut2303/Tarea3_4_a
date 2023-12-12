package com.example.tarea3_4_a.entidades;

public class Producto {
    private String producto;
    private double cantidad;

    public Producto(String producto, double cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto() {
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
}
