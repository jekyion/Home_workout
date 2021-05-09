package com.home_wrokout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class ExTimerActivity extends AppCompatActivity {
    private TextView timer;
    private TextView exc;
    private ImageView iv;
    int images[]={R.drawable.pushup,R.drawable.pushup,R.drawable.fire,R.drawable.fire,R.drawable.fire};
    private boolean isBreak=true;
    CountDownTimer cTimer = null;
    private int i=0;

    String[] cwp={"1","2","3","4","5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_timer);
        iv= findViewById(R.id.imageView3);
        timer = findViewById(R.id.textView);
        exc = findViewById(R.id.textView2);
        iv.setImageResource(images[0]);
        exc.setText(cwp[0]);
        startTimer(3000);

    }

    void startTimer(int x) {

        cTimer = new CountDownTimer(x, 1000) {
            public void onTick(long millisUntilFinished) {
                timer.setText("" + millisUntilFinished / 1000);
            }
            public void onFinish() {

                    if (isBreak) {

                        isBreak = false;
                        exc.setTextSize(36);
                        if (i== cwp.length-1){
                            exc.setText("Koniec");
                            openBrzuchPozActivity();
                        }else {
                            exc.setText("Przerwa, następne ćwiczenie: " + cwp[i + 1]);
                            iv.setImageResource(images[i + 1]);
                            i++;
                            startTimer(2000);
                        }


                    } else {
                        isBreak = true;
                        exc.setText(cwp[i]);
                        iv.setImageResource(images[i]);
                        startTimer(3000);

                    }

            }

        };
        cTimer.start();
    }
    public void openBrzuchPozActivity(){
        Intent intent = new Intent(this, BrzuchPozActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStop() {
        super.onStop();

    }
}