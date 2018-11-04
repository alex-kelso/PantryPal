package com.example.athen.pantrypal;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class AnalyticsActivity extends AppCompatActivity {

    public static int analyticsWaste = 0;
    public static int totalMoney = 0;
    public double MoneyWaster = (totalMoney / analyticsWaste) * 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analytics);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button SwitchToMain = findViewById(R.id.Back);
        SwitchToMain.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent myIntent = new Intent(AnalyticsActivity.this,
                        MainActivity.class);
                startActivity(myIntent);
            }
        });

        TextView textOutput3 = findViewById(R.id.Output3);
        textOutput3.setText("You have spent $" + totalMoney + " on groceries");

        TextView textOutput = findViewById(R.id.Output);
        textOutput.setText("Your monthly waste is $" + analyticsWaste);


        TextView textOutput2 = findViewById(R.id.Output2);
        textOutput2.setText("That is  " + MoneyWaster + "% of your food");
    }




}
