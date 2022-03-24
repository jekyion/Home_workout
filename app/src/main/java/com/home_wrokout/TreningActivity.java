package com.home_wrokout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.home_wrokout.Level.AbsActivity;
import com.home_wrokout.Level.ChestActivity;
import com.home_wrokout.Level.LegsAzctivity;
import com.home_wrokout.Level.BackActivity;
import com.home_wrokout.Level.ArmsActivity;

public class TreningActivity extends AppCompatActivity {
    private Button abs;
    private Button chest;
    private Button arms;
    private Button legs;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treningi);

        abs =findViewById(R.id.button5);
        chest =findViewById(R.id.button4);
        arms =findViewById(R.id.button);
        legs =findViewById(R.id.button2);
        back =findViewById(R.id.button3);
        abs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {openBrzuchPozActivity();}
        });

        chest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {openKlataPozActivity();}
        });

        arms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {openRamionaPozActivity();}
        });

        legs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {openNogiPozActivity();}
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {openPlecyPozActivity();}
        });

    }
    public void openBrzuchPozActivity(){
        Intent intent = new Intent(this, AbsActivity.class);
        startActivity(intent);
    }
    public void openKlataPozActivity(){
        Intent intent = new Intent(this, ChestActivity.class);
        startActivity(intent);
    }
    public void openRamionaPozActivity(){
        Intent intent = new Intent(this, ArmsActivity.class);
        startActivity(intent);
    }

    public void openNogiPozActivity(){
        Intent intent = new Intent(this, LegsAzctivity.class);
        startActivity(intent);
    }

    public void openPlecyPozActivity(){
        Intent intent = new Intent(this, BackActivity.class);
        startActivity(intent);
    }
}