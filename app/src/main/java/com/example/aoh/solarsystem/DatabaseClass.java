package com.example.aoh.solarsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
    private static final String DATABASE_NAME = "solar_system";

    // Table Name
    private static final String TABLE_MEMBERS = "members";
    private static final String TABLE_SCORES = "scores";

    public DatabaseClass(Context context) {
        super(context, DATABASE_NAME, null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String table_members = "CREATE TABLE " + TABLE_MEMBERS +
                "(MemberID INTEGER PRIMARY KEY AUTOINCREMENT," +
                " Name TEXT(10),"+
                " Surname TEXT(20),"+
                " StudentCode TEXT(20),"+
                " TeacherName TEXT(20));";
        String table_scores = "CREATE TABLE " + TABLE_SCORES +
                "(ScoreID INTEGER PRIMARY KEY AUTOINCREMENT," +
                " MemberID TEXT(10)," +
                " PreScore TEXT(10)," +
                " PostScore TEXT(20));";
        db.execSQL(table_members);
        db.execSQL(table_scores);
        Log.d("CREATE TABLE", "Create Table Successfully.");

    }

    // Insert User
    public long InsertData(String strMemberID,
                           String strName,
                           String strSurname,
                           String strStudentCode,
                           String strTeacherName) {
        try {
            SQLiteDatabase db;
            db = this.getWritableDatabase(); // Write Data
            ContentValues Val = new ContentValues();
            Val.put("MemberID", strMemberID);
            Val.put("Name", strName);
            Val.put("Surname", strSurname);
            Val.put("StudentCode", strStudentCode);
            Val.put("TeacherName", strTeacherName);
            long rows = db.insert(TABLE_MEMBERS, null, Val);
            db.close();
            return rows; // return rows inserted.
        } catch (Exception e) {
            return -1;
        }
    }

    // SelectData() ใช้สำหรับการตรวจสอบข้อมูลว่ามีอยู่แล้วหรือยัง
    public String[] SelectData(String strStudentCode) {
        try {
            String arrData[] = null;

            SQLiteDatabase db;
            db = this.getReadableDatabase(); // Read Data

            Cursor cursor = db.query(TABLE_MEMBERS, new String[] { "*" },
                    "StudentCode=?",
                    new String[] { String.valueOf(strStudentCode) }, null, null, null, null);

            if(cursor != null)
            {
                if (cursor.moveToFirst()) {
                    arrData = new String[cursor.getColumnCount()];
                    arrData[0] = cursor.getString(0);
                    arrData[1] = cursor.getString(1);
                    arrData[2] = cursor.getString(2);
                    arrData[3] = cursor.getString(3);
                    arrData[4] = cursor.getString(4);
                }
            }
            cursor.close();
            db.close();
            return arrData;

        } catch (Exception e) {
            return null;
        }

    }

    // Select ผู้ใช้งานทั้งหมด
    public Cursor SelectAllData() {
        // TODO Auto-generated method stub

        try {
            SQLiteDatabase db;
            db = this.getReadableDatabase(); // Read Data
            String strSQL = "SELECT StudentCode As _stdCode , * FROM " + TABLE_MEMBERS;
            Cursor cursor = db.rawQuery(strSQL, null);

            return cursor;

        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
