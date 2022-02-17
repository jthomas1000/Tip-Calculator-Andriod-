package com.example.lab2a;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import com.example.lab2a.databinding.ActivityMainBinding;
import android.os.Bundle;


import java.math.BigDecimal;
import java.text.NumberFormat;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String r = "100";

                BigDecimal rounder = new BigDecimal(r);
                String i = String.valueOf(binding.editTip);
                BigDecimal tipCalc = new BigDecimal(i);
                String e = String.valueOf(binding.editTotalbill);
                BigDecimal billCalc = new BigDecimal(e);
                String o = String.valueOf(binding.editPeople);
                BigDecimal peopleCalc = new BigDecimal(o);

               if (i.equals("") || i.equals("0")){
                   binding.outputField.setText("");
               }
               else if (e.equals("") || e.equals("0")){
                    binding.outputField.setText("");
               }
               else if (o.equals("") || o.equals("0")){
                    binding.outputField.setText("");
               }
               else{
                   BigDecimal tipTotal = billCalc.multiply(tipCalc.divide(rounder));
                   BigDecimal billTotal = billCalc.add(tipTotal);
                   BigDecimal finalTotal = billTotal.divide(peopleCalc);

                   double amount = finalTotal.doubleValue();
                   NumberFormat nf = NumberFormat.getCurrencyInstance();
                   String currency = nf.format(amount);
                   binding.outputField.setText(currency);

               }
            }
        });

    }
}
