package com.hanbit.user.myapp2.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hanbit.user.myapp2.calc.CalcActivity;
import com.hanbit.user.myapp2.group.GroupActivity;
import com.hanbit.user.myapp2.kaup.KaupActivity;
import com.hanbit.user.myapp2.R;
import com.hanbit.user.myapp2.login.LoginActivity;
import com.hanbit.user.myapp2.movie.MovieActivity;
import com.hanbit.user.myapp2.signup.SignupActivity;


public class MainActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ((Button)findViewById(R.id.btKaup)).setOnClickListener(this);
        ((Button)findViewById(R.id.btCalc)).setOnClickListener(this);
        ((Button)findViewById(R.id.btLogin)).setOnClickListener(this);
        ((Button)findViewById(R.id.btnSignup)).setOnClickListener(this);
        ((Button)findViewById(R.id.btnGroup)).setOnClickListener(this);
        ((Button)findViewById(R.id.btnMovie)).setOnClickListener(this);



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
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.btnSignup:
                startActivity(new Intent(this, SignupActivity.class));
                break;
            case R.id.btnGroup:
                startActivity(new Intent(this, GroupActivity.class));
                break;
            case R.id.btnMovie:
                startActivity(new Intent(this, MovieActivity.class));
                break;

        }
    }
}
