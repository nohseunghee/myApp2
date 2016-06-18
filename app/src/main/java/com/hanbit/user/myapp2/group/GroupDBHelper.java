package com.hanbit.user.myapp2.group;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by USER on 2016-06-18.
 */
public class GroupDBHelper extends SQLiteOpenHelper{
    private static final String DB_NAME = "hanbitDB";
    private static final int DB_Version = 1;

    public GroupDBHelper(Context context) {
        super(context, DB_NAME, null, DB_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table group (_id integer primary key, name text, num integer");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists group");
        this.onCreate(db);;
    }
}
