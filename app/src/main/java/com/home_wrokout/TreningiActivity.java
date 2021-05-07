package com.home_wrokout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TreningiActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treningi);

        button=findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {openBrzuchPozActivity();}
        });

    }
    public void openBrzuchPozActivity(){
        Intent intent = new Intent(this, BrzuchPozActivity.class);
        startActivity(intent);
    }
}