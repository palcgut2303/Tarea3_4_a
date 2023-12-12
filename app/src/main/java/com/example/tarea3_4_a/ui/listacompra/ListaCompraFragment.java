package com.example.tarea3_4_a.ui.listacompra;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tarea3_4_a.R;
import com.example.tarea3_4_a.adaptadores.AdaptadorProducto;
import com.example.tarea3_4_a.databinding.FragmentListaCompraBinding;
import com.example.tarea3_4_a.entidades.Producto;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class ListaCompraFragment extends Fragment {

    private FragmentListaCompraBinding binding;
    private ListaCompraViewModel listaCompraViewModel;
    private RecyclerView rv;
    private AdaptadorProducto adaptador;
    private List<Producto> datos = new ArrayList<>();
    private Context contexto;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ListaCompraViewModel listaCompraViewModel =
                new ViewModelProvider(this).get(ListaCompraViewModel.class);

        //Obtenemos el contexto de ejecución de la actividad de la aplicación.
        contexto = this.getActivity();
        //Por ahora añadimos algunos datos de prueba a la lista de la compra
        datos.add(new Producto("Leche", 2));
        datos.add(new Producto("Carne", 1));
        datos.add(new Producto("Lechugas", 2));
        datos.add(new Producto("Barra de pan", 2));
        datos.add(new Producto("Rioja", 1));

        binding = FragmentListaCompraBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.titulo;

        listaCompraViewModel = new ListaCompraViewModel();
        listaCompraViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);


        //Vinculamos el RecyclerView del código al del Layout.
        rv = binding.recyclerView;

        //Si el contenido del RecyclerView es fijo y no variará durante la ejecución
        //de la aplicación, es conveniente poner la propiedad de tamaño fijo a true.
        rv.setHasFixedSize(true);

        //Creamos el adaptador
        adaptador = new AdaptadorProducto(contexto, datos);

        //Asignamos el adaptador al RecyclerView
        rv.setAdapter(adaptador);

        //Asignamos un LinearLayout vertical al RecyclerView de forma que los datos se vean en
        //formato lista.
        rv.setLayoutManager( new LinearLayoutManager(contexto, LinearLayoutManager.VERTICAL,false));
        //Registramos al RecyclerView como destino del menú contextual.
        registerForContextMenu(rv);

        return root;
    }

    //Método en el que tratamos las acciones correspondientes a la opción de menú contextual seleccionada
    //por el usuario.
    @SuppressLint("NotifyDataSetChanged")
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int posicion = -1;
        try {
            posicion = adaptador.getPosicion();
        } catch (Exception e) {
            return super.onContextItemSelected(item);
        }
        int itemId = item.getItemId();
        if (itemId == R.id.mi1) {
            Snackbar.make(this.rv, "Se ha elegido editar el elemento " + posicion, Snackbar.LENGTH_LONG)
                    .show();
            //Se tendría que realizar la llamada al método que permitiera la edición del elemento actual.
        } else if (itemId == R.id.mi2) {
            Snackbar.make(this.rv, "Se ha elegido borrar el elemento " + posicion, Snackbar.LENGTH_LONG)
                    .show();
            datos.remove(posicion);
            adaptador.notifyDataSetChanged();
        } else if (itemId == R.id.mi3) {
            Snackbar.make(this.rv, "Se ha elegido añadir un elemento.", Snackbar.LENGTH_LONG)
                    .show();
            datos.add(new Producto("Chocolate", 2));
            adaptador.notifyDataSetChanged();
        }
        return super.onContextItemSelected(item);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}