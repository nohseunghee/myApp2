package com.hanbit.user.myapp2.group;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

    public String TAG;

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
        ghelper    = new GroupDBHelper(this);
        Cursor cursor = null;
        GroupBean gbean = new GroupBean();  //인스턴스(객체) 생성

        String strId = "번호\r\n----\r\n";
        String strNames = "그룹이름\r\n----\r\n";
        String strNumbers = "인원\r\n----\r\n";



        switch(v.getId()) {
            case R.id.btnInit://초기화
                db = ghelper.getWritableDatabase();
                ghelper.onUpgrade(db,1,2);
                break;
            case R.id.btnCount:   //그룹수

                resultMsg = "그룹수";
                db = ghelper.getReadableDatabase();
                cursor = db.rawQuery("select * from girl_group   ",null);
                //txtResult.setText("그룹수: "+cursor.getInt(0));
                txtResult.setText("그룹수: "+cursor.getCount());

                cursor.close();
                break;
            case R.id.btnlist:  //리스트
                resultMsg = "리스트";
                db = ghelper.getReadableDatabase();
                cursor = db.rawQuery("select * from girl_group ",null);

                while(cursor.moveToNext()){
                    strId += cursor.getInt(0)+"\r\n";
                    strNames += cursor.getString(1)+"\r\n";
                    strNumbers += cursor.getInt(2)+"\r\n";
                }

                txtResult.setText(strNames);
                cursor.close();
                break;
            case R.id.btnSearch://조회
                gbean.setName(etName.getText().toString());
                gbean.setCnt(Integer.parseInt(etCnt.getText().toString()));

                resultMsg = "조회됨";
                db = ghelper.getReadableDatabase();
                cursor = db.rawQuery("select * from girl_group where name='"+gbean.getName()+"' and num='"+gbean.getCnt()+"' ",null);

                cursor.moveToNext();
                //cursor.moveToFirst();
                strId += String.valueOf(cursor.getInt(0));
                strNames += cursor.getString(1);
                strNumbers += String.valueOf(cursor.getInt(2));

                txtResult.setText(strNames);
                cursor.close();
                break;
            case R.id.btnInsert://입력


                gbean.setName(etName.getText().toString());
                gbean.setCnt(Integer.parseInt(etCnt.getText().toString()));

                resultMsg = "입력됨";
                db = ghelper.getWritableDatabase();
                db.execSQL("insert into girl_group (name,num) values ('"+gbean.getName()+"','"+gbean.getCnt()+"')");

                break;

            case R.id.btnMod://수정
                gbean.setName(etName.getText().toString());
                gbean.setCnt(Integer.parseInt(etCnt.getText().toString()));

                resultMsg = "수정됨";
                db = ghelper.getWritableDatabase();
                db.execSQL("update girl_group set num='"+gbean.getCnt()+"' where _id='1' ");
                break;
            case R.id.btnDel://삭제
                resultMsg = "삭제됨";
                db = ghelper.getWritableDatabase();
                db.execSQL("delete from girl_group where _id = '10' ");

                break;
        }
        db.close();
        Toast.makeText(getApplicationContext(),resultMsg, Toast.LENGTH_LONG).show();
        return;


    }
}
