package com.hanbit.user.myapp2.calc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hanbit.user.myapp2.R;
import com.hanbit.user.myapp2.main.MainActivity;

public class CalcActivity extends Activity implements View.OnClickListener{

    EditText etNum1, etNum2;
    TextView txtResult;

    int num1, num2;

    CalcService service;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);


        etNum1      = (EditText)findViewById(R.id.etNum1);
        etNum2      = (EditText)findViewById(R.id.etNum2);
        txtResult   = (TextView)findViewById(R.id.txtResult);


        service = new CalcServiceImpl();


        ((Button)findViewById(R.id.btnPlus)).setOnClickListener(this);
        ((Button)findViewById(R.id.btnMinus)).setOnClickListener(this);
        ((Button)findViewById(R.id.btnMutiple)).setOnClickListener(this);
        ((Button)findViewById(R.id.btnDivision)).setOnClickListener(this);
        ((Button)findViewById(R.id.btnExtra)).setOnClickListener(this);
        ((Button)findViewById(R.id.btnMain)).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        //
        if(v.getId() == R.id.btnMain){
            startActivity(new Intent(this, MainActivity.class));
        }else {

            num1 = Integer.parseInt(etNum1.getText().toString());
            num2 = Integer.parseInt(etNum2.getText().toString());

            int result = 0;

            switch (v.getId()) {//v == xml
                case R.id.btnPlus:
                    result = service.plus(num1, num2);
                    break;
                case R.id.btnMinus:
                    result = service.minus(num1, num2);
                    break;
                case R.id.btnMutiple:
                    result = service.multi(num1, num2);
                    break;
                case R.id.btnDivision:
                    result = service.divide(num1, num2);
                    break;
                case R.id.btnExtra:
                    result = service.nmg(num1, num2);
                    break;
            }

            txtResult.setText("계산결과 : " + result);
        }


    }



}
