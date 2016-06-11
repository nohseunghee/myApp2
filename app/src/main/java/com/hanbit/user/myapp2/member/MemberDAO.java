package com.hanbit.user.myapp2.member;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by USER on 2016-06-11.
 * 데이터베이스 접근에 특화된 class
 */
public class MemberDAO extends SQLiteOpenHelper{
    //생성자
    //public MemberDAO(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
    public MemberDAO(Context context) { //데이터베이스 연결
        //content, DB_NAME, null, DB_Version
        //super(context, name, factory, version);
        super(context, null, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {   //데이터베이스 만들기
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
        MemberBean mem = new MemberBean();
        return mem;
    }

    public MemberBean update(MemberBean member) {
        MemberBean mem = new MemberBean();
        return mem;
    }

    public String delete(MemberBean member) {
        return "삭제완료";
    }
}
