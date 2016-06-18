package com.hanbit.user.myapp2.group;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by USER on 2016-06-18.
 */
public class GroupDBHelper extends SQLiteOpenHelper{
    private static final String DB_NAME = "hanbitDB";
    private static final int DB_Version = 1;

    public String TAG;

    public GroupDBHelper(Context context) {
        super(context, DB_NAME, null, DB_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG, "ok2");
        db.execSQL("create table girl_group (_id integer primary key, name text, num integer);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i(TAG, "ok1");
        db.execSQL("drop table if exists girl_group");
        this.onCreate(db);;
    }
}
