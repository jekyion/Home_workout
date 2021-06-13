package com.home_wrokout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ImageView;
import android.widget.TextView;

import com.home_wrokout.poziom.BrzuchPozActivity;

import java.util.ArrayList;

public class ExTimerActivity extends AppCompatActivity {
    private TextView timer;
    private TextView exc;
    private ImageView iv;
   // int images[]={R.drawable.pushup,R.drawable.mountainclimber,R.drawable.fire,R.drawable.fire,R.drawable.fire};
    private boolean isBreak=true;
    private CountDownTimer cTimer = null;
    private int i=0;
    private ArrayList<String> cwp;
    private ArrayList<Integer> icp;

    //String[] cwp=b.getStringArray("cwp");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_timer);
        iv= findViewById(R.id.imageView3);
        timer = findViewById(R.id.textView);
        exc = findViewById(R.id.textView2);
        cwp = getIntent().getStringArrayListExtra("cwp");
        icp = getIntent().getIntegerArrayListExtra("icp");
        iv.setImageResource(icp.get(0));
        exc.setText(cwp.get(0));
        startTimer(30000);

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
                        if (i== (cwp.size())-1){
                            exc.setText("Koniec");
                            openBrzuchPozActivity();
                        }else {
                            exc.setText("Przerwa, następne ćwiczenie: " + cwp.get(i + 1));
                            iv.setImageResource(icp.get(i + 1));
                            i++;
                            startTimer(15000);
                        }


                    } else {
                        isBreak = true;
                        exc.setText(cwp.get(i));
                        iv.setImageResource(icp.get(i));
                        startTimer(30000);

                    }

            }

        };
        cTimer.start();
        ;
    }
    public void openBrzuchPozActivity(){
        Intent intent = new Intent(this, BrzuchPozActivity.class);
        startActivity(intent);
    }
    protected void onStop() {
        super.onStop();  // Always call the superclass method first
        cTimer.cancel();
    }
}