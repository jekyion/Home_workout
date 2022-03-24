package com.home_wrokout.Level;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.home_wrokout.ExTimerActivity;
import com.home_wrokout.R;

import java.util.ArrayList;

public class BackActivity extends AppCompatActivity {

    private Button pocz;
    private Button sred;
    private Button zaw;
    // String[] cwp={"1","2","3","4","5"};
    private ArrayList<String> cwp = new ArrayList<String>();
    private ArrayList<Integer> icp = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plecy_poz);




        pocz=findViewById(R.id.plecypocz);
        pocz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listAddPocz();
                openExTimerActivity();
            }
        });
        sred=findViewById(R.id.plecysred);
        sred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listAddSred();
                openExTimerActivity();
            }
        });
        zaw=findViewById(R.id.plecyzaaw);
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
        cwp.add("KNEE PUSH_UP");
        cwp.add("ARM SCISSORS");
        cwp.add("CAT COW POSE");

        icp.clear();
        icp.add(R.drawable.jumpingjacks);
        icp.add(R.drawable.arm_raises);
        icp.add(R.drawable.knee_pushup);
        icp.add(R.drawable.arm_scissors);
        icp.add(R.drawable.cat_cow);
    }
    public void listAddSred(){
        cwp.clear();
        cwp.add("JUMPING JACKS");
        cwp.add("INCLINE PUSH-UP");
        cwp.add("CAT COW POSE");
        cwp.add("INCLINE PUSH-UP");
        cwp.add("SUPERMAN");
        cwp.add("CAT COW POSE");
        cwp.add("CHILD'S POSE");

        icp.clear();
        icp.add(R.drawable.jumpingjacks);
        icp.add(R.drawable.incline_pushup);
        icp.add(R.drawable.cat_cow);
        icp.add(R.drawable.incline_pushup);
        icp.add(R.drawable.superman);
        icp.add(R.drawable.cat_cow);
        icp.add(R.drawable.child_pose);
    }
    public void listAddZaw(){
        cwp.clear();
        cwp.add("JUMPING JACKS");
        cwp.add("INCLINE PUSH-UP");
        cwp.add("CAT COW POSE");
        cwp.add("INCLINE PUSH-UP");
        cwp.add("SUPERMAN");
        cwp.add("CAT COW POSE");
        cwp.add("SUPERMAN");
        cwp.add("CHILD'S POSE");

        icp.clear();
        icp.add(R.drawable.jumpingjacks);
        icp.add(R.drawable.incline_pushup);
        icp.add(R.drawable.cat_cow);
        icp.add(R.drawable.incline_pushup);
        icp.add(R.drawable.superman);
        icp.add(R.drawable.cat_cow);
        icp.add(R.drawable.superman);
        icp.add(R.drawable.child_pose);
    }
}