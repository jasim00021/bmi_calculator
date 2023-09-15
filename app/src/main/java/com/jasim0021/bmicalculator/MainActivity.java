package com.jasim0021.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout llMain;
        EditText edtWeight, editHeightFt, editHeightInc;
        Button calculate;
        TextView result;
        llMain = findViewById(R.id.llMain);
        edtWeight = findViewById(R.id.editWeight);
        editHeightFt = findViewById(R.id.editHeight);
        editHeightInc = findViewById(R.id.editheightInc);
        calculate = findViewById(R.id.calculate);
        result = findViewById(R.id.textResult);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wt = Integer.parseInt(edtWeight.getText().toString()) ;
                int hIF = Integer.parseInt(editHeightFt.getText().toString()) ;
                int hIi = Integer.parseInt(editHeightInc.getText().toString()) ;

                int totalInc = hIF * 12 + hIi ;
                double totalCm = totalInc * 2.53 ;

                double totalM = totalCm/100;

                double bmi = wt/(totalM*totalM);

                if(bmi>25){
                    result.setText("You are overWeight");
                    llMain.setBackgroundColor(getResources().getColor(R.color.over_weight));
                } else if (bmi < 18 ){
                    result.setText("yo are underWeight");
                    llMain.setBackgroundColor(getResources().getColor(R.color.under_weight));
                }
                else{
                    result.setText("yo are Healty");
                    llMain.setBackgroundColor(getResources().getColor(R.color.healty));
                }

            }

        });


    }
}