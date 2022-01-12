package com.example.rvasgridview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rvasgridview.R;
import com.example.rvasgridview.model.Fruit;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<Fruit> fruits;

    public CustomAdapter(Context context, ArrayList<Fruit> fruits) {
        this.context = context;
        this.fruits = fruits;
    }


    @Override
    public int getItemCount() {
        return fruits.size();
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_custom_layout_view, parent, false);
        return new CustomViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Fruit fruit = fruits.get(position);

        if (holder instanceof CustomViewHolder) {
            ImageView imageView = ((CustomViewHolder) holder).imageView;
            imageView.setImageResource(fruit.getImage());
        }
    }


    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public ImageView imageView;

        public CustomViewHolder(View v) {
            super(v);
            this.view = v;
            imageView = view.findViewById(R.id.imageView);
        }

    }


}
