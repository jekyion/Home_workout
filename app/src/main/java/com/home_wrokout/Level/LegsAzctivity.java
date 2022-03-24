package com.home_wrokout.Level;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.home_wrokout.ExTimerActivity;
import com.home_wrokout.R;

import java.util.ArrayList;

public class LegsAzctivity extends AppCompatActivity {

    private Button pocz;
    private Button sred;
    private Button zaw;
    // String[] cwp={"1","2","3","4","5"};
    private ArrayList<String> cwp = new ArrayList<String>();
    private ArrayList<Integer> icp = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nogi_poz);




        pocz=findViewById(R.id.nogipocz);
        pocz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listAddPocz();
                openExTimerActivity();
            }
        });
        sred=findViewById(R.id.nogisred);
        sred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listAddSred();
                openExTimerActivity();
            }
        });
        zaw=findViewById(R.id.nogizaaw);
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
        cwp.add("SQUATS");
        cwp.add("SQUATS");
        cwp.add("BACKWARD LUNGE");
        cwp.add("DONKEY KICKS LEFT");
        cwp.add("DONKEY KICKS RIGHT");

        icp.clear();
        icp.add(R.drawable.jumpingjacks);
        icp.add(R.drawable.squats);
        icp.add(R.drawable.squats);
        icp.add(R.drawable.backward_lunge);
        icp.add(R.drawable.donkey_kicks);
        icp.add(R.drawable.donkey_kicks);
    }
    public void listAddSred(){
        cwp.clear();
        cwp.add("JUMPING JACKS");
        cwp.add("SQUATS");
        cwp.add("SQUATS");
        cwp.add("BACKWARD LUNGE");
        cwp.add("BACKWARD LUNGE");
        cwp.add("SIDE LEG CIRCLES LEFT");
        cwp.add("SIDE LEG CIRCLES RIGHT");
        cwp.add("SUMO SQUAT");
        cwp.add("SUMO SQUAT");
        cwp.add("WALL SIT");

        icp.clear();
        icp.add(R.drawable.jumpingjacks);
        icp.add(R.drawable.squats);
        icp.add(R.drawable.squats);
        icp.add(R.drawable.backward_lunge);
        icp.add(R.drawable.backward_lunge);
        icp.add(R.drawable.leg_circles);
        icp.add(R.drawable.leg_circles);
        icp.add(R.drawable.sumo_squat);
        icp.add(R.drawable.sumo_squat);
        icp.add(R.drawable.wall_sit);
    }
    public void listAddZaw(){
        cwp.clear();
        cwp.add("JUMPING JACKS");
        cwp.add("BURPEES");
        cwp.add("SQUATS");
        cwp.add("SQUATS");
        cwp.add("BACKWARD LUNGE");
        cwp.add("BACKWARD LUNGE");
        cwp.add("SIDE LEG CIRCLES LEFT");
        cwp.add("SIDE LEG CIRCLES RIGHT");
        cwp.add("SIDE LEG CIRCLES LEFT");
        cwp.add("SIDE LEG CIRCLES RIGHT");
        cwp.add("JUMPING SQUATS");
        cwp.add("JUMPING SQUATS");
        cwp.add("SUMO SQUAT");
        cwp.add("SUMO SQUAT");
        cwp.add("QUAD STRETCH");
        cwp.add("WALL SIT");

        icp.clear();
        icp.add(R.drawable.jumpingjacks);
        icp.add(R.drawable.burpees);
        icp.add(R.drawable.squats);
        icp.add(R.drawable.squats);
        icp.add(R.drawable.backward_lunge);
        icp.add(R.drawable.backward_lunge);
        icp.add(R.drawable.leg_circles);
        icp.add(R.drawable.leg_circles);
        icp.add(R.drawable.leg_circles);
        icp.add(R.drawable.leg_circles);
        icp.add(R.drawable.jumping_squats);
        icp.add(R.drawable.jumping_squats);
        icp.add(R.drawable.sumo_squat);
        icp.add(R.drawable.sumo_squat);
        icp.add(R.drawable.quad_stretch);
        icp.add(R.drawable.wall_sit);

    }
}