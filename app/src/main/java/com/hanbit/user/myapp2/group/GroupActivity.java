package com.hanbit.user.myapp2.group;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hanbit.user.myapp2.R;
import com.hanbit.user.myapp2.main.MainActivity;

public class GroupActivity extends Activity implements View.OnClickListener{
    EditText etName, etCnt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
        etName = (EditText)findViewById(R.id.etName);
        etCnt = (EditText)findViewById(R.id.etCnt);

        ((Button)findViewById(R.id.btnInit)).setOnClickListener(this);
        ((Button)findViewById(R.id.btnInsert)).setOnClickListener(this);
        ((Button)findViewById(R.id.btnSearch)).setOnClickListener(this);
        ((Button)findViewById(R.id.btnMod)).setOnClickListener(this);
        ((Button)findViewById(R.id.btnDel)).setOnClickListener(this);
        ((Button)findViewById(R.id.btnMain)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnInit:
                break;
            case R.id.btnInsert:
                break;
            case R.id.btnSearch:
                break;
            case R.id.btnMod:
                break;
            case R.id.btnDel:
                break;
            case R.id.btnMain:  //메인으로
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }
}
