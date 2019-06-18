package com.example.myexperiment02_mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.example.myexperiment02_mvvm.databinding.ActivityMainBinding;
import com.example.myexperiment02_mvvm.viewmodel.NewsViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        NewsViewModel newsViewModel = ViewModelProviders.of(this).get(NewsViewModel.class);
        binding.setNewsVM(newsViewModel);
        binding.setLifecycleOwner(this);
    }
}
