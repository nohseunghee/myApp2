package com.hanbit.user.myapp2.group;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hanbit.user.myapp2.R;
import com.hanbit.user.myapp2.main.MainActivity;

public class GroupActivity extends Activity implements View.OnClickListener{
    EditText etName, etCnt;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
        etName = (EditText)findViewById(R.id.etName);
        etCnt = (EditText)findViewById(R.id.etCnt);
        txtResult = (TextView)findViewById(R.id.txtResult);


        ((Button)findViewById(R.id.btnInit)).setOnClickListener(this);
        ((Button)findViewById(R.id.btnInsert)).setOnClickListener(this);
        ((Button)findViewById(R.id.btnSearch)).setOnClickListener(this);
        ((Button)findViewById(R.id.btnMod)).setOnClickListener(this);
        ((Button)findViewById(R.id.btnDel)).setOnClickListener(this);
        ((Button)findViewById(R.id.btnMain)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnMain){    //메인으로
            startActivity(new Intent(this, MainActivity.class));
            return;
        }

        if(v.getId() == R.id.btnInit){  //초기화
            etCnt.setText("");
            etName.setText("");
            txtResult.setText("");
            return;
        }

        GroupBean group = new GroupBean();  //인스턴스(객체) 생성
        group.setName(etName.getText().toString());
        group.setCnt(Integer.parseInt(etCnt.getText().toString()));


        //GroupService service = new GroupServiceImpl();
        /*
        GroupDBHelper helper = new GroupDBHelper(this);
        member = dao.login(member);
        * */

        switch(v.getId()){
            case R.id.btnInsert://입력
                break;
            case R.id.btnSearch://조회
                break;
            case R.id.btnMod://수정
                break;
            case R.id.btnDel://삭제
                break;
            case R.id.btnMain:

                break;
        }
    }
}
