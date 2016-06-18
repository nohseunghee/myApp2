package com.hanbit.user.myapp2.group;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hanbit.user.myapp2.R;
import com.hanbit.user.myapp2.main.MainActivity;

public class GroupActivity extends Activity implements View.OnClickListener{
    EditText etName, etCnt;
    TextView txtResult;
    GroupDBHelper ghelper;
    SQLiteDatabase db;

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
        ((Button)findViewById(R.id.btnlist)).setOnClickListener(this);
        ((Button)findViewById(R.id.btnCount)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnMain){    //메인으로
            startActivity(new Intent(this, MainActivity.class));
            return;
        }
        String resultMsg = "";


        GroupBean gbean = new GroupBean();  //인스턴스(객체) 생성
        gbean.setName(etName.getText().toString());
        gbean.setCnt(Integer.parseInt(etCnt.getText().toString()));

        ghelper    = new GroupDBHelper(this);
        db = ghelper.getWritableDatabase();

        //GroupService service = new GroupServiceImpl();
        /*

        member = dao.login(member);
        * */
        switch(v.getId()){
            case R.id.btnInit://초기화
                ghelper.onUpgrade(db,1,2);
                break;
            case R.id.btnCount:   //그룹수
                resultMsg = "전체리스트";
                db.rawQuery("select count(_id) from group   ",null);
                break;
            case R.id.btnlist:  //리스트
                resultMsg = "전체리스트";
                db.rawQuery("select * from group where name='IOI'  ",null);
                break;
            case R.id.btnInsert://입력
                resultMsg = "입력됨";
                db.execSQL("insert into group (name,num) values (IOI','20')");
                break;
            case R.id.btnSearch://조회
                resultMsg = "조회됨";
                db.rawQuery("select * from group where name='IOI' limit 10 ",null);
                break;
            case R.id.btnMod://수정
                resultMsg = "수정됨";
                db.execSQL("update group set name='ttt', num='333' ");
                break;
            case R.id.btnDel://삭제
                resultMsg = "삭제됨";
                db.execSQL("delete from group where _id = '1' ");
                break;
        }
        db.close();

        Toast.makeText(getApplicationContext(),resultMsg, Toast.LENGTH_LONG).show();
    }
}
