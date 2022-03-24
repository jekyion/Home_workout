package com.home_wrokout.Level;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.home_wrokout.ExTimerActivity;
import com.home_wrokout.R;

import java.util.ArrayList;

public class ArmsActivity extends AppCompatActivity {

    private Button pocz;
    private Button sred;
    private Button zaw;
    // String[] cwp={"1","2","3","4","5"};
    private ArrayList<String> cwp = new ArrayList<String>();
    private ArrayList<Integer> icp = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ramiona_poz);




        pocz=findViewById(R.id.ramionapocz);
        pocz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listAddPocz();
                openExTimerActivity();
            }
        });
        sred=findViewById(R.id.ramionasred);
        sred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listAddSred();
                openExTimerActivity();
            }
        });
        zaw=findViewById(R.id.ramionazaaw);
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
        cwp.add("ARM RAISES");
        cwp.add("DIAMOND PUSH-UPS");
        cwp.add("PUNCHES");
        cwp.add("WALL PUSH-UPS");

        icp.clear();
        icp.add(R.drawable.jumpingjacks);
        icp.add(R.drawable.arm_raises);
        icp.add(R.drawable.diamond_push_up);
        icp.add(R.drawable.punches);
        icp.add(R.drawable.wall_push_up);
    }
    public void listAddSred(){
        cwp.clear();
        cwp.add("JUMPING JACKS");
        cwp.add("PUSH-UPS");
        cwp.add("PUSH UPS & ROTATION");
        cwp.add("DIAMOND PUSH-UPS");
        cwp.add("BURPEES");
        cwp.add("PUSH-UPS");
        cwp.add("ARM SCISSORS");

        icp.clear();
        icp.add(R.drawable.jumpingjacks);
        icp.add(R.drawable.pushup);
        icp.add(R.drawable.pushup_rotation);
        icp.add(R.drawable.diamond_push_up);
        icp.add(R.drawable.burpees);
        icp.add(R.drawable.pushup);
        icp.add(R.drawable.arm_scissors);
    }
    public void listAddZaw(){
        cwp.clear();
        cwp.add("JUMPING JACKS");
        cwp.add("SKIPPING WITHOUT ROPE");
        cwp.add("BURPESS");
        cwp.add("PUSH-UPS");
        cwp.add("PUSH UPS & ROTATION");
        cwp.add("TRICEPS STRETCH LEFT");
        cwp.add("TRICEPS STRETCH RIGHT");
        cwp.add("BURPESS");
        cwp.add("PUSH UPS & ROTATION");
        cwp.add("PUNCHES");
        cwp.add("ARM RAISES");

        icp.clear();
        icp.add(R.drawable.jumpingjacks);
        icp.add(R.drawable.skipping);
        icp.add(R.drawable.burpees);
        icp.add(R.drawable.pushup);
        icp.add(R.drawable.pushup_rotation);
        icp.add(R.drawable.triceps_stretch);
        icp.add(R.drawable.triceps_stretch);
        icp.add(R.drawable.burpees);
        icp.add(R.drawable.pushup_rotation);
        icp.add(R.drawable.punches);
        icp.add(R.drawable.arm_raises);
    }
}