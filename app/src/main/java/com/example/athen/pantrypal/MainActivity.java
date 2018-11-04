package com.example.athen.pantrypal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class MainActivity extends AppCompatActivity {
    private List<Food> foodList = new ArrayList<>();
    private RecyclerView recyclerView;
    private FoodsAdapter mAdapter;

    private String name;
    private String amount;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAmount() {
        return amount;
    }

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

        EditText NewAmount = findViewById(R.id.NewAmount);
        NewAmount.setVisibility(View.GONE);

        Button Done = findViewById(R.id.Done);
        Done.setVisibility(View.GONE);

        Button Done2 = findViewById(R.id.Done2);
        Done2.setVisibility(View.GONE);

        Switch Waste = findViewById(R.id.WasteSwitch);
        Waste.setVisibility(View.GONE);

        Button SwitchToAnalytics = findViewById(R.id.Analytics);
        SwitchToAnalytics.setOnClickListener(new View.OnClickListener() {
                                                 public void onClick(View arg0) {
                                                     Intent myIntent = new Intent(MainActivity.this,
                                                             AnalyticsActivity.class);
                                                     startActivity(myIntent);
                                                 }
                                             });
        Button SwitchToRecipes = findViewById(R.id.Recipe);
        SwitchToRecipes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent myIntent = new Intent(MainActivity.this,
                        Recipes.class);
                startActivity(myIntent);
            }
        });

        preparefoodData();
    }

    private void preparefoodData() {
        mAdapter.notifyDataSetChanged();
    }

    public void Add(View view) {
        Button SwitchToAnalytics = findViewById(R.id.Analytics);
        SwitchToAnalytics.setVisibility(View.GONE);
        Button SwitchToRecipe = findViewById(R.id.Recipe);
        SwitchToRecipe.setVisibility(View.GONE);
        Button Add = findViewById(R.id.Add);
        Add.setVisibility(View.GONE);
        Button Remove = findViewById(R.id.Remove);
        Remove.setVisibility(View.GONE);
        Button Done = findViewById(R.id.Done);
        Done.setVisibility(View.VISIBLE);
        EditText NewFood = findViewById(R.id.NewFood);
        NewFood.setEnabled(true);
        EditText NewAmount = findViewById(R.id.NewAmount);
        NewAmount.setEnabled(true);

        PantryPalItems foo = new PantryPalItems();
        foo.createItemArr();

        name = getNameInput();
        amount = getAmountInput();
        for (Item i: foo.ItemArr) {
            if (name.equals(i.getName())) {
                Food food = new Food(i.getName(), i.getCategory(), i.getExpiration(), i.getMultipleType(), i.getPricePerMultipleType());
                foodList.add(food);
                int foo1 = food.getPricePerMultipleType();
                AnalyticsActivity.totalMoney += foo1;
                preparefoodData();
            }
        }
    }

    public void Remove(View view) {
        Button SwitchToAnalytics = findViewById(R.id.Analytics);
        SwitchToAnalytics.setVisibility(View.GONE);
        Button SwitchToRecipe = findViewById(R.id.Recipe);
        SwitchToRecipe.setVisibility(View.GONE);
        Button Add = findViewById(R.id.Add);
        Add.setVisibility(View.GONE);
        Button Remove = findViewById(R.id.Remove);
        Remove.setVisibility(View.GONE);
        Button Done = findViewById(R.id.Done2);
        Done.setVisibility(View.VISIBLE);
        EditText NewFood = findViewById(R.id.NewFood);
        NewFood.setEnabled(true);
        Switch Waste = findViewById(R.id.WasteSwitch);
        Waste.setVisibility(View.VISIBLE);

        name = getNameInput();
        boolean waste = Waste.isChecked();
        for(Food f: foodList) {
            if (name.equals(f.getName())) {
                foodList.remove(f);
                if (!(waste)) {
                    int foo = f.getPricePerMultipleType();
                    AnalyticsActivity.analyticsWaste += foo;
                }
                preparefoodData();
            } else {

            }
        }
    }

    public void Done(View v) {
        Add(v);
        hideInput();
        Button Done = findViewById(R.id.Done);
        Done.setVisibility(View.GONE);
        EditText NewFood = findViewById(R.id.NewFood);
        NewFood.getText().clear();
        Button Add = findViewById(R.id.Add);
        Add.setVisibility(View.VISIBLE);
        Button Remove = findViewById(R.id.Remove);
        Remove.setVisibility(View.VISIBLE);
        Button Analytics = findViewById(R.id.Analytics);
        Analytics.setVisibility(View.VISIBLE);
        Button Recipe = findViewById(R.id.Recipe);
        Recipe.setVisibility(View.VISIBLE);
    }

    public void Done2(View v) {
        Remove(v);
        hideInput();
        Switch Waste = findViewById(R.id.WasteSwitch);
        Waste.setVisibility(View.GONE);
        Button Done = findViewById(R.id.Done2);
        Done.setVisibility(View.GONE);
        EditText NewFood = findViewById(R.id.NewFood);
        NewFood.getText().clear();
        Button Add = findViewById(R.id.Add);
        Add.setVisibility(View.VISIBLE);
        Button Remove = findViewById(R.id.Remove);
        Remove.setVisibility(View.VISIBLE);
        Button Analytics = findViewById(R.id.Analytics);
        Analytics.setVisibility(View.VISIBLE);
        Button Recipe = findViewById(R.id.Recipe);
        Recipe.setVisibility(View.VISIBLE);
    }

    public String getNameInput() {
        EditText NewFood = findViewById(R.id.NewFood);
        NewFood.setVisibility(View.VISIBLE);
        String foo  = NewFood.getText().toString();
        return foo;
    }

    public String getAmountInput() {
        EditText NewAmount = findViewById(R.id.NewAmount);
        NewAmount.setVisibility(View.VISIBLE);
        String foo = NewAmount.getText().toString();
        return foo;
    }

    public void hideInput() {
        EditText NewFood = findViewById(R.id.NewFood);
        NewFood.setVisibility(View.GONE);
        NewFood.setEnabled(false);

        EditText NewAmount = findViewById(R.id.NewAmount);
        NewAmount.setVisibility(View.GONE);
        NewAmount.setEnabled(false);
    }
}