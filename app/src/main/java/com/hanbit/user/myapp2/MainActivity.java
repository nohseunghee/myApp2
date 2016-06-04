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
    EditText weight;
    EditText height;
    EditText name;
    TextView resultCalc;
    Button btnCalc;
    String resultMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        weight = (EditText)findViewById(R.id.weight);
        height = (EditText)findViewById(R.id.height);
        name = (EditText)findViewById(R.id.name);
        resultCalc = (TextView)findViewById(R.id.resultCalc);
        btnCalc = (Button)findViewById(R.id.btnCalc);



        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //공식
                //몸무게를 키의 제곱으로 나눈후, 10000을 곱한 인덱스 값
                //int idx = (int)(weight/(height * height)) * 10000;

                int nheight = Integer.parseInt(height.getText().toString());
                int nweight = Integer.parseInt(weight.getText().toString());

                int idx = (int)(nweight/(nheight * nheight)) * 10000;


                if(idx >= 30){ //비만
                    resultMsg = "비만";
                }else if(idx >= 24){ //과체중
                    resultMsg = "과체중";
                }else if(idx >= 20){ //정상
                    resultMsg = "정상";
                }else if(idx >= 15){ //저체중
                    resultMsg = "저체중";
                }else if(idx >= 13){ //마름
                    resultMsg = "마름";
                }else if(idx >= 10){ //영양실조
                    resultMsg = "영양실조";
                }else{//소모증
                    resultMsg = "소모증";
                }
                resultCalc.setText(name.getText()+"님의 계산결과: " + resultMsg);

            }
        });

    }
}
