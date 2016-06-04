package com.hanbit.user.myapp2.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hanbit.user.myapp2.calc.CalcActivity;
import com.hanbit.user.myapp2.kaup.KaupActivity;
import com.hanbit.user.myapp2.R;


public class MainActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ((Button)findViewById(R.id.btKaup)).setOnClickListener(this);
        ((Button)findViewById(R.id.btCalc)).setOnClickListener(this);
        ((Button)findViewById(R.id.btLogin)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btKaup:
                //Intent.ACTION_DIAL == this (현재 )
                //uri = http://naver.com
                startActivity(new Intent(this, KaupActivity.class));
                //Intent intent = new Intent(this, KaupActivity.class); 를 쓰면 메모리가 많이 잡아먹으므로, 줄임
                break;
            case R.id.btCalc:
                startActivity(new Intent(this, CalcActivity.class));
                break;
            case R.id.btLogin:
                startActivity(new Intent(this, KaupActivity.class));
                break;

        }
    }
}
