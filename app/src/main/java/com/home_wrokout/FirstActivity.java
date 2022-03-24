package com.home_wrokout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FirstActivity extends AppCompatActivity {
    EditText height;
    EditText weight;
    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        height =findViewById(R.id.wzrost);
        weight =findViewById(R.id.waga);
        next =findViewById(R.id.lol);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {saveBMI(height, weight);openMainPozActivity();}


        });
    }
    public void saveBMI(EditText height, EditText weight) {
        SharedPreferences sharedPref = getSharedPreferences("bmi", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("WZROST", height.getText().toString());
        editor.putString("WAGA", weight.getText().toString());
        editor.apply();
    }
    public void openMainPozActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}