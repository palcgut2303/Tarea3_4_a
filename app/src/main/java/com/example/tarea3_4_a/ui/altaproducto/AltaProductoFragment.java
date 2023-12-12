package com.example.tarea3_4_a.ui.altaproducto;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.tarea3_4_a.databinding.FragmentAltaProductoBinding;

public class AltaProductoFragment extends Fragment {

    private EditText etProducto, etCantidad;
    private Button btAceptar;
    private FragmentAltaProductoBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentAltaProductoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        etProducto = binding.etProducto;
        etCantidad = binding.etCantidad;
        btAceptar = binding.btAceptar;
        //Método que desencadena el guardado de los datos del formulario en la base de datos.
        btAceptar.setOnClickListener(v -> {
            // Pendiente de implementar.
        });

        return root;
    }
}