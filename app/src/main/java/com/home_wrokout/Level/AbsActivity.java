package com.home_wrokout.Level;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;

import com.home_wrokout.ExTimerActivity;
import com.home_wrokout.R;

public class AbsActivity extends AppCompatActivity {
    private Button pocz;
    private Button sred;
    private Button zaw;
   // String[] cwp={"1","2","3","4","5"};
    private ArrayList<String> cwp = new ArrayList<String>();
    private ArrayList<Integer> icp = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brzuch_poz);




        pocz=findViewById(R.id.button8);
        pocz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listAddPocz();
                openExTimerActivity();
            }
        });
        sred=findViewById(R.id.button7);
        sred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listAddSred();
                openExTimerActivity();
            }
        });
        zaw=findViewById(R.id.button6);
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
        cwp.add("HEEL TOUCH");
        cwp.add("MOUNTAIN CLIMBER");
        cwp.add("LEG RAISES");
        cwp.add("BUTT BRIDGE");
        cwp.add("PLANK");

        icp.clear();
        icp.add(R.drawable.heeltouch);
        icp.add(R.drawable.mountainclimber);
        icp.add(R.drawable.legraises);
        icp.add(R.drawable.buttbridge);
        icp.add(R.drawable.plank);
    }
    public void listAddZaw(){
        cwp.clear();
        cwp.add("SIT-UPS");
        cwp.add("COBRA STRETCH");
        cwp.add("BICYCLE CRUNCHES");
        cwp.add("ABDOMINAL CRUNCHES");
        cwp.add("PLANK");

        icp.clear();
        icp.add(R.drawable.situp);
        icp.add(R.drawable.cobrastretch);
        icp.add(R.drawable.bicyclecrunches);
        icp.add(R.drawable.abdominalcrunches);
        icp.add(R.drawable.plank);
    }
}