package com.example.android3hw1.view;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.android3hw1.model.MainModel;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends ViewModel {

    public MutableLiveData<List<MainModel>> mutableLiveData = new MutableLiveData<>();
    public ArrayList<MainModel> list = new ArrayList<>();


    public ArrayList<MainModel> getList() {
        list.add(new MainModel("Alexandr", "Android 3"));
        list.add(new MainModel("ArzYmaT", "Android 3"));
        list.add(new MainModel("Arsen", "Android 3"));
        list.add(new MainModel("Fatma", "Android 3"));
        mutableLiveData.setValue(list);
        return list;

    }
}
