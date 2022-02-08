package com.example.lab2a;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import com.example.lab2a.databinding.ActivityMainBinding;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }
}