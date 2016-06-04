package com.hanbit.user.myapp2.testCalc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hanbit.user.myapp2.R;

public class CalcActivity extends Activity implements View.OnClickListener{

    EditText etNum1, etNum2;
    TextView txtResult;
    Button btnPlus, btnMinus, btnMutiple, btnDivision, btnExtra;

    int num1, num2;

    CalcService service;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);


        etNum1      = (EditText)findViewById(R.id.etNum1);
        etNum2      = (EditText)findViewById(R.id.etNum2);
        btnPlus     = (Button)findViewById(R.id.btnPlus);
        btnMinus    = (Button)findViewById(R.id.btnMinus);
        btnMutiple  = (Button)findViewById(R.id.btnMutiple);
        btnDivision = (Button)findViewById(R.id.btnDivision);
        btnExtra    = (Button)findViewById(R.id.btnExtra);
        txtResult   = (TextView)findViewById(R.id.txtResult);


        service = new CalcServiceImpl();


        btnPlus.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnMutiple.setOnClickListener(this);
        btnDivision.setOnClickListener(this);
        btnExtra.setOnClickListener(this);
        txtResult.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        num1 = Integer.parseInt(etNum1.getText().toString());
        num2 = Integer.parseInt(etNum2.getText().toString());



        int result = 0;

        switch (v.getId()){//v == xml
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
