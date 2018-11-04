package com.example.athen.pantrypal;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class FoodsAdapter extends RecyclerView.Adapter<FoodsAdapter.MyViewHolder> {

    private List<Food> foodsList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, type, expiration;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            type = (TextView) view.findViewById(R.id.type);
            expiration = (TextView) view.findViewById(R.id.expiration);
        }
    }


    public FoodsAdapter(List<Food> foodsList) {
        this.foodsList = foodsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.food_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Food food = foodsList.get(position);
        holder.name.setText(food.getName());
        holder.type.setText(food.getType());
        holder.expiration.setText(food.getExpiration());
    }

    @Override
    public int getItemCount() {
        return foodsList.size();
    }
}