package com.example.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

     int quantity = 0;
     Spinner spinner;
     ArrayList spinnerArrayList;
     ArrayAdapter spinnerAdapter;

     HashMap goodsMap;
     String goodsName;
     double price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        spinnerArrayList = new ArrayList();

        spinnerArrayList.add("guitar");
        spinnerArrayList.add("drums");
        spinnerArrayList.add("keyboard");

        spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerArrayList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        goodsMap = new HashMap();
        goodsMap.put("guitar", 500.0);
        goodsMap.put("drums", 1500.0);
        goodsMap.put("keyboard", 1000.0);

    }


    public void increaseQuantity(View view) {
        quantity = quantity + 1;
        TextView textView4 = findViewById(R.id.textView4);
        textView4.setText("" + quantity);
        TextView priceTextView = findViewById(R.id.priceTextView);
        priceTextView.setText("" + quantity * price);
    }

    public void decreaseQunity(View view) {
        quantity = quantity - 1;
        if (quantity<0) {
            quantity=0;
        }
        TextView textView4 = findViewById(R.id.textView4);
        textView4.setText("" + quantity);
        TextView priceTextView = findViewById(R.id.priceTextView);
        priceTextView.setText("" + quantity * price);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        goodsName = spinner.getSelectedItem().toString();
        price = (double)goodsMap.get(goodsName);
        TextView priceTextView = findViewById(R.id.priceTextView);
        priceTextView.setText("" + quantity * price);

        ImageView goodsImageView = findViewById(R.id.goodsImageView);

        if(goodsName.equals("guitar")){
            goodsImageView.setImageResource(R.drawable.__png);
        } else if(goodsName.equals("drums")){
            goodsImageView.setImageResource(R.drawable.__png);
        }else if(goodsName.equals("keyboard")){
            goodsImageView.setImageResource(R.drawable.__png);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}