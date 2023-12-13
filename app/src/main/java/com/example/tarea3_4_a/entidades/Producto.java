package com.example.tarea3_4_a.entidades;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//Anotación para indicar que una clase es una entidad Room
@Entity
public class Producto {

    //Anotación que indica cual es la clave primaria de la tabla
    @PrimaryKey(autoGenerate = true)
    //Anotación que permite asignar el atributo al campo de la tabla
    @ColumnInfo(name = "_id")
    public int uid;

    //Anotación que permite asignar el atributo al campo de la tabla
    @ColumnInfo(name = "producto")
    private String producto;

    //Anotación que permite asignar el atributo al campo de la tabla
    @ColumnInfo(name = "cantidad")
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

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
