package com.example.athen.pantrypal;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private List<Food> foodList = new ArrayList<>();
    private RecyclerView recyclerView;
    private FoodsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new FoodsAdapter(foodList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        EditText NewFood = findViewById(R.id.NewFood);
        NewFood.setVisibility(View.GONE);

        preparefoodData();
    }

    private void preparefoodData() {
        mAdapter.notifyDataSetChanged();
    }

    public void Add(View view) {
        String newName = getAddInput();
        Food food = new Food(newName, null, null);
        foodList.add(food);
        preparefoodData();
    }

    public String getAddInput() {
        EditText NewFood = findViewById(R.id.NewFood);
        NewFood.setVisibility(View.VISIBLE);
        String newName = NewFood.getText().toString();
        return newName;
    }

    public void Remove(View view) {
        foodList.remove(0);

        preparefoodData();
    }
}