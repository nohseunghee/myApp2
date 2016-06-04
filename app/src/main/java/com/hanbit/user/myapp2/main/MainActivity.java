package com.hanbit.user.myapp2.main;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hanbit.user.myapp2.R;


public class MainActivity extends Activity implements View.OnClickListener{
    Button btKaup;
    Button btCalc;
    Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btKaup = (Button)findViewById(R.id.btKaup);
        btCalc = (Button)findViewById(R.id.btCalc);
        btLogin = (Button)findViewById(R.id.btLogin);

        btKaup.setOnClickListener(this);
        btCalc.setOnClickListener(this);
        btLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btKaup:
                break;
            case R.id.btCalc:
                break;
            case R.id.btLogin:
                break;

        }
    }
}
