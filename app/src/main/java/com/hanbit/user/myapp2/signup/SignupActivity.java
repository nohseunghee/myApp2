package com.hanbit.user.myapp2.signup;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hanbit.user.myapp2.R;

public class SignupActivity extends Activity implements View.OnClickListener{
    EditText etId, etPW, etName, etEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etId = (EditText)findViewById(R.id.etID);
        etPW = (EditText)findViewById(R.id.etPW);
        etName = (EditText)findViewById(R.id.etName);
        etEmail = (EditText)findViewById(R.id.etEmail);

        ((Button)findViewById(R.id.btnSignup)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
