package com.example.aoh.solarsystem;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Aoh on 8/9/2559.
 */

public class DatabaseClass extends SQLiteOpenHelper{

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "mydatabase";

    // Table Name
    private static final String TABLE_MEMBER = "members";

    public DatabaseClass(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {



        db.execSQL("CREATE TABLE Members "+
                    "(member_ID INTEGER PRIMARY KEY,"+
                    "member_name TEXT(20),"+
                    "member_surname TEXT(20),"+
                    "member_code INTEGER(10),"+
                    "member_teacher TEXT(20));");
        Log.d("CREATE TABLE", "Create Table Members Successfully.");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
