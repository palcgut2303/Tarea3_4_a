package com.example.tarea3_4_a.ui.listacompra;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.AndroidViewModel;

import com.example.tarea3_4_a.basedatos.BaseDatosApp;
import com.example.tarea3_4_a.entidades.Producto;

import java.io.Closeable;
import java.util.List;

public class ListaCompraViewModel extends AndroidViewModel  {

    private final LiveData<List<Producto>> productos;
    public ListaCompraViewModel(@NonNull Application application) {
        super(application);
        //Inicializamos el contenido de la lista, al de la tabla de la base de datos
        productos = BaseDatosApp
                .getInstance(application)
                .productoDAO().getAll();
    }

    public LiveData<List<Producto>> getProductos() {
        return productos;
    }
}