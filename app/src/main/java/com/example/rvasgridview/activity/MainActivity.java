package com.example.rvasgridview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.rvasgridview.R;
import com.example.rvasgridview.adapter.CustomAdapter;
import com.example.rvasgridview.model.Fruit;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    protected Context context;
    protected RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        ArrayList<Fruit> fruits = prepareFruitList();
        refreshAdapter(fruits);

    }

    private void initViews() {
        context = this;
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 3));
    }


    private void refreshAdapter(ArrayList<Fruit> fruits) {
        CustomAdapter adapter = new CustomAdapter(context, fruits);
        recyclerView.setAdapter(adapter);
    }


    private ArrayList<Fruit> prepareFruitList() {
        ArrayList<Fruit> fruits = new ArrayList<>();
        int helper = 0;

        for (int i = 1; i < 61; i++) {
            if ((i + 3 - helper) % 3 == 1) {
                fruits.add(new Fruit(R.drawable.apple));
            } else if ((i + 3 - helper) % 3 == 2) {
                fruits.add(new Fruit(R.drawable.pineapple));
            } else {
                fruits.add(new Fruit(R.drawable.orange));
            }
            if (i % 3 == 0) helper++;
        }
        return fruits;
    }


}