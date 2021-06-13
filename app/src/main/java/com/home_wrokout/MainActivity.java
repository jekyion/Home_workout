package com.home_wrokout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.home_wrokout.Alarm_RecyclerView.Alarm_activity;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Button plan;
    private Button raport;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("isFirstRun", true);
        if (isFirstRun) {
            startActivity(new Intent(MainActivity.this, FirstActivity.class));
        }
        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit().putBoolean("isFirstRun", false).commit();

        button=findViewById(R.id.button12);
        plan=findViewById(R.id.button10);
        raport=findViewById(R.id.button13);
        plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAlarm_activity();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               openTreningiActivity();
            }
        });

        raport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRaportActivity();
            }
        });
    }
    public void openTreningiActivity(){
        Intent intent = new Intent(this, TreningiActivity.class);
        startActivity(intent);
    }
    public void openAlarm_activity(){
        Intent intent = new Intent(this, Alarm_activity.class);
        startActivity(intent);
    }
    public void openRaportActivity(){
        Intent intent = new Intent(this, RaportActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

}