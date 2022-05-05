package com.example.android3hw1;

import androidx.appcompat.app.AppCompatActivity;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;

import com.example.android3hw1.adapter.Adapter;

import com.example.android3hw1.databinding.ActivityMainBinding;
import com.example.android3hw1.model.MainModel;
import com.example.android3hw1.view.MainViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    MainViewModel viewModel;
    public Adapter adapter = new Adapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        setupListener();
        addObserver();
        initAdapter();
    }


    private void initAdapter() {
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        binding.homeRecycler.setAdapter(adapter);
    }


    public void addObserver(){

        viewModel.mutableLiveData.observe(this, new Observer<List<MainModel>>() {
            @Override
            public void onChanged(List<MainModel> mainModels) {
                adapter.setData(mainModels);
            }
        });
    }

    private void setupListener() {

        binding.displayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addObserver();
                viewModel.getList();
                binding.displayBtn.setVisibility(View.GONE);
            }
        });
    }
}