package com.example.tarea3_4_a.ui.listacompra;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ListaCompraViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ListaCompraViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}