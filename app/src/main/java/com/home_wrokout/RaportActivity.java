package com.home_wrokout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class RaportActivity extends AppCompatActivity {
    public static final String BMI_CATEGORY_UNDERWEIGHT = "Niedowaga";
    public static final String BMI_CATEGORY_HEALTHY = "Waga prawidłowa";
    public static final String BMI_CATEGORY_OVERWEIGHT = "Nadwaga";
    public static final String BMI_CATEGORY_OBESE = "Skrajna otyłość";
    TextView bmi;
    TextView kat;
    Button policz;
    EditText wzrostpob;
    EditText wagapob;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raport);
        ImageView img= (ImageView) findViewById(R.id.bmiimage);
        img.setImageResource(R.drawable.imagebmi);
        bmi=findViewById(R.id.textView6);
        kat=findViewById(R.id.textView9);
        policz=findViewById(R.id.policz);
        wzrostpob=findViewById(R.id.wzrost);
        wagapob=findViewById(R.id.waga);

        SharedPreferences preferences = getSharedPreferences("bmi", MODE_PRIVATE);
        String waga = preferences.getString("WAGA","70");
        String wzrost = preferences.getString("WZROST","180" );
        if ((wzrost !=null) || (waga !=null)){
            wzrostpob.setText(wzrost);
            wagapob.setText(waga);
            Float x = calculateBMIMetric(Float.valueOf(wzrost), Float.valueOf(waga));
            bmi.setText(String.format("%.2f", x));
            kat.setText(classifyBMI(x));
        }
        policz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Float x = calculateBMIMetric(Float.valueOf(wzrostpob.getText().toString()),Float.valueOf(wagapob.getText().toString()));
                bmi.setText(String.format("%.2f",x));
                kat.setText(classifyBMI(x));

                saveBMI(wzrostpob,wagapob);
            }


        });

    }

    public float calculateBMIMetric(float heightCm, float weightKg) {

        return (weightKg / ((heightCm / 100) * (heightCm / 100)));
    }

    public String classifyBMI(float bmi) {
        if (bmi < 18.5) {
            return BMI_CATEGORY_UNDERWEIGHT;
        } else if (bmi >= 18.5 && bmi < 25) {
            return BMI_CATEGORY_HEALTHY;
        } else if (bmi >= 25 && bmi < 30){
            return BMI_CATEGORY_OVERWEIGHT;
        } else {
            return BMI_CATEGORY_OBESE;
        }
    }

    public void saveBMI(EditText wzrost, EditText waga) {
        SharedPreferences sharedPref = getSharedPreferences("bmi", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("WZROST", wzrost.getText().toString());
        editor.putString("WAGA", waga.getText().toString());
        editor.apply();
    }
}