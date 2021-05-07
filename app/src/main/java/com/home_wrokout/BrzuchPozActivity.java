package com.home_wrokout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class BrzuchPozActivity extends AppCompatActivity {
    private Button pocz;
    private Button sred;
    private Button zaw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brzuch_poz);

        pocz=findViewById(R.id.button8);
        pocz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openExTimerActivity();
            }
        });
        sred=findViewById(R.id.button7);
        sred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openExTimerActivity();
            }
        });
        zaw=findViewById(R.id.button6);
        zaw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openExTimerActivity();
            }
        });
    }
    public void openExTimerActivity(){
        Intent intent = new Intent(this, ExTimerActivity.class);
        startActivity(intent);
    }
}