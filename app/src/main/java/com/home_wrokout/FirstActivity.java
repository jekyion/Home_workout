package com.home_wrokout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.home_wrokout.poziom.BrzuchPozActivity;

public class FirstActivity extends AppCompatActivity {
    EditText wzrost;
    EditText waga;
    Button dalej;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        wzrost=findViewById(R.id.wzrost);
        waga=findViewById(R.id.waga);
        dalej=findViewById(R.id.lol);


        dalej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {saveBMI(wzrost,waga);openMainPozActivity();}


        });
    }
    public void saveBMI(EditText wzrost, EditText waga) {
        SharedPreferences sharedPref = getSharedPreferences("bmi", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("WZROST", wzrost.getText().toString());
        editor.putString("WAGA", waga.getText().toString());
        editor.apply();
    }
    public void openMainPozActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}