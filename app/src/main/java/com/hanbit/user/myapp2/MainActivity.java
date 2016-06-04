package com.hanbit.user.myapp2;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    EditText etWeight, etHeight, etName;
    TextView resultCalc;
    Button btnCalc;

    String name, resultText;
    double weight, height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etWeight = (EditText)findViewById(R.id.weight);
        etHeight = (EditText)findViewById(R.id.height);
        etName = (EditText)findViewById(R.id.name);
        resultCalc = (TextView)findViewById(R.id.resultCalc);
        btnCalc = (Button)findViewById(R.id.btnCalc);





        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                name = etName.getText().toString();
                height = Double.parseDouble(etHeight.getText().toString());
                weight = Double.parseDouble(etWeight.getText().toString());
                //Integer.parseInt(~~~~) :: 정수 casting


                //공식
                //몸무게를 키의 제곱으로 나눈후, 10000을 곱한 인덱스 값
                //int idx = (int)(weight/(height * height)) * 10000;
                int idx = (int)(weight/(height * height)) * 10000;


                if(idx >= 30){ //비만
                    resultText = "비만";
                }else if(idx >= 24){ //과체중
                    resultText = "과체중";
                }else if(idx >= 20){ //정상
                    resultText = "정상";
                }else if(idx >= 15){ //저체중
                    resultText = "저체중";
                }else if(idx >= 13){ //마름
                    resultText = "마름";
                }else if(idx >= 10){ //영양실조
                    resultText = "영양실조";
                }else{//소모증
                    resultText = "소모증";
                }
                resultCalc.setText(name+"님의 계산결과: " + resultText);
            }
        });

    }
}
