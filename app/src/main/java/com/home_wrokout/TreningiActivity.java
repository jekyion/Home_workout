package com.home_wrokout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TreningiActivity extends AppCompatActivity {
    private Button brzuch;
    private Button klata;
    private Button ramiona;
    private Button nogi;
    private Button plecy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treningi);

        brzuch=findViewById(R.id.button5);
        klata=findViewById(R.id.button4);
        ramiona=findViewById(R.id.button);
        nogi=findViewById(R.id.button2);
        plecy=findViewById(R.id.button3);
        brzuch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {openBrzuchPozActivity();}
        });

        klata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {openKlataPozActivity();}
        });

        ramiona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {openRamionaPozActivity();}
        });

        nogi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {openNogiPozActivity();}
        });

        plecy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {openPlecyPozActivity();}
        });

    }
    public void openBrzuchPozActivity(){
        Intent intent = new Intent(this, BrzuchPozActivity.class);
        startActivity(intent);
    }
    public void openKlataPozActivity(){
        Intent intent = new Intent(this,KlataPozActivity.class);
        startActivity(intent);
    }
    public void openRamionaPozActivity(){
        Intent intent = new Intent(this,RamionaPozActivity.class);
        startActivity(intent);
    }

    public void openNogiPozActivity(){
        Intent intent = new Intent(this,NogiPozAzctivity.class);
        startActivity(intent);
    }

    public void openPlecyPozActivity(){
        Intent intent = new Intent(this,PlecyPozActivity.class);
        startActivity(intent);
    }
}