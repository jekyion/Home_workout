package com.home_wrokout.Level;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.home_wrokout.ExTimerActivity;
import com.home_wrokout.R;

import java.util.ArrayList;

public class ChestActivity extends AppCompatActivity {

    private Button pocz;
    private Button sred;
    private Button zaw;
    // String[] cwp={"1","2","3","4","5"};
    private ArrayList<String> cwp = new ArrayList<String>();
    private ArrayList<Integer> icp = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_klata_poz);




        pocz=findViewById(R.id.klatapocz);
        pocz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listAddPocz();
                openExTimerActivity();
            }
        });
        sred=findViewById(R.id.klatasred);
        sred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listAddSred();
                openExTimerActivity();
            }
        });
        zaw=findViewById(R.id.klatazaaw);
        zaw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listAddZaw();
                openExTimerActivity();
            }
        });
    }
    public void openExTimerActivity(){
        Bundle b=new Bundle();
        Bundle c=new Bundle();
        b.putStringArrayList("cwp",cwp);
        c.putIntegerArrayList("icp",icp);
        Intent i = new Intent(this, ExTimerActivity.class);
        i.putExtras(b);
        i.putExtras(c);
        startActivity(i);
    }
    public void listAddPocz(){
        cwp.clear();
        cwp.add("JUMPING JACKS");
        cwp.add("ABDOMINAL CRUNCHES");
        cwp.add("MOUNTAIN CLIMBER");
        cwp.add("HEEL TOUCH");
        cwp.add("PLANK");

        icp.clear();
        icp.add(R.drawable.jumpingjacks);
        icp.add(R.drawable.abdominalcrunches);
        icp.add(R.drawable.mountainclimber);
        icp.add(R.drawable.heeltouch);
        icp.add(R.drawable.plank);
    }
    public void listAddSred(){
        cwp.clear();
        cwp.add("JUMPING JACKS");
        cwp.add("PUSH-UP");
        cwp.add("WIDE ARM PUSH-UP");
        cwp.add("HINDU PUSH-UP");
        cwp.add("PUSH-UP & ROTATION");
        cwp.add("HINDU PUSH-UP");
        cwp.add("DECLINE PUSH-UP");
        cwp.add("SHOULDER STRETCH");
        cwp.add("COBRA STRETCH");

        icp.clear();
        icp.add(R.drawable.jumpingjacks);
        icp.add(R.drawable.pushup);
        icp.add(R.drawable.wide_push_up);
        icp.add(R.drawable.hindu_pushup);
        icp.add(R.drawable.pushup_rotation);
        icp.add(R.drawable.hindu_pushup);
        icp.add(R.drawable.decline_pushup);
        icp.add(R.drawable.shoulder_stretch);
        icp.add(R.drawable.cobrastretch);

    }
    public void listAddZaw(){

        cwp.clear();
        cwp.add("JUMPING JACKS");
        cwp.add("SHOULDER STRETCH");
        cwp.add("BURPEES");
        cwp.add("HINDU PUSH-UP");
        cwp.add("PUSH-UP & ROTATION");
        cwp.add("DIAMOND PUSH-UP");
        cwp.add("HINDU PUSH-UP");
        cwp.add("DECLINE PUSH-UP");
        cwp.add("BURPEES");
        cwp.add("SHOULDER STRETCH");
        cwp.add("COBRA STRETCH");

        icp.clear();
        icp.add(R.drawable.jumpingjacks);
        icp.add(R.drawable.shoulder_stretch);
        icp.add(R.drawable.burpees);
        icp.add(R.drawable.hindu_pushup);
        icp.add(R.drawable.pushup_rotation);
        icp.add(R.drawable.diamond_push_up);
        icp.add(R.drawable.hindu_pushup);
        icp.add(R.drawable.decline_pushup);
        icp.add(R.drawable.burpees);
        icp.add(R.drawable.shoulder_stretch);
        icp.add(R.drawable.cobrastretch);

    }
}