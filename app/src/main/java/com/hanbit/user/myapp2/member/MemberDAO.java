package com.hanbit.user.myapp2.member;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by USER on 2016-06-11.
 * 데이터베이스 접근에 특화된 class
 */
public class MemberDAO extends SQLiteOpenHelper{
    private static final String DB_NAME = "hanbitDB";
    private static final int DB_Version = 1;

    //생성자
    //public MemberDAO(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
    public MemberDAO(Context context) { //데이터베이스 연결
        //content, DB_NAME, null, DB_Version
        //super(context, name, factory, version);
        super(context, DB_NAME, null, DB_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {   //데이터베이스 만들기
        //db.execSQL("create table member3 (id text, pw text, name text, email text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {  //데이터베이스 변경
    }


    public String signup(MemberBean member) {//데이터 저장
        String id = member.getId();
        String pw = member.getPw();
        String name = member.getName();
        String email = member.getEmail();

        Log.i("id",id);
        Log.i("pw",pw);
        Log.i("name",name);
        Log.i("email",email);

        return "회원가입을 축하합니다";
    }

    public MemberBean login(MemberBean member) {


        //SQLiteDatabase db = this.getWritableDatabase(); :: insert 용
        SQLiteDatabase db = this.getReadableDatabase();

        //sql을 실행하라
        //select * from member where id='test1' and pw='1234';
        Cursor cursor = db.rawQuery("select id, pw, name, email from `member` where id='"+member.getId()+"' and pw='"+member.getPw()+"'", null);

        String cid = "";
        String cpw = "";
        String cName = "";
        String cEmail = "";

        while (cursor.moveToNext()){
            cid = cursor.getString(0);
            cpw = cursor.getString(1);
            cName = cursor.getString(2);
            cEmail = cursor.getString(3);
        }


        MemberBean mem = new MemberBean();
        mem.setId(cid);
        mem.setPw(cpw);
        mem.setName(cName);
        mem.setEmail(cEmail);


        Log.i("id", cid);
        Log.i("pw",cpw);
        Log.i("name",cName);
        Log.i("email",cEmail);

        cursor.close();
        db.close();

        return mem;
    }

    /*
    자료가 여러개일 경우
    public MemberBean login(MemberBean member) {
        ArrayList<MemberBean> list = new ArrayList<MemberBean>()

        SQLiteDatabase db = this.getReadableDatabase();

        //sql을 실행하라
        //select * from member where id='test1' and pw='1234';
        Cursor cursor = db.rawQuery("select id, pw, name, email from member where id='"+member.getId()+"' and pw='"+member.getPw()+"'", null);

        String cid = "";
        String cpw = "";
        String cName = "";
        String cEmail = "";

        while (cursor.moveToNext()){
            MemberBean mem = new MemberBean();

            cid = cursor.getString(0);
            cpw = cursor.getString(1);
            cName = cursor.getString(2);
            cEmail = cursor.getString(3);

            mem.setId(cid);
            mem.setPw(cpw);
            mem.setName(cName);
            mem.setEmail(cEmail);

            list.add(mem);
        }

        Log.i("id", cid);
        Log.i("pw",cpw);
        Log.i("name",cName);
        Log.i("email",cEmail);

        cursor.close();
        db.close();

        return mem;
    }
    */

    public MemberBean update(MemberBean member) {
        MemberBean mem = new MemberBean();
        return mem;
    }

    public String delete(MemberBean member) {
        return "삭제완료";
    }
}
