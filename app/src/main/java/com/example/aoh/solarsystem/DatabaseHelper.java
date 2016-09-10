package com.example.aoh.solarsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Aoh on 9/9/2559.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "solar_system.db";
    private static final String TABLE_MEMBERS = "members";
    private static final String TABLE_SCORES = "scores";
    private static final String COLUMN_MEMBER_ID = "memId";
    private static final String COLUMN_MEMBER_NAME = "name";
    private static final String COLUMN_MEMBER_SURNAME = "surname";
    private static final String COLUMN_MEMBER_STUDENT_CODE = "studentCode";
    private static final String COLUMN_MEMBER_TEACHER_NAME = "teacherName";
    private static final String COLUMN_SCORE_ID = "scoreId";
    private static final String COLUMN_SCORE_PRETEST = "preScore";
    private static final String COLUMN_SCORE_POSTEST = "postScore";

    //Check SignUp
    private static final String CHECK_SIGNCODE = "checkSignCode";
    //Check Login
    private static final String CHECK_LOGNAME = "checkLogName";
    private static final String CHECK_LOGCODE = "checkLogCode";

    SQLiteDatabase db;

    private static final String TABLE_MEMBER_CREATE = "CREATE TABLE MEMBERS " +
                                                        "(MemberID INTEGER PRIMARY KEY AUTOINCREMENT, Name TEXT(10), " +
                                                        "Surname TEXT(20), StudentCode TEXT(20), TeacherName TEXT(20))";
    private static final String TABLE_SCORE_CREATE = "CREATE TABLE SCORES (ScoreID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                                        "MemberID TEXT(10), PreScore TEXT(10), PostScore TEXT(20))";

    public DatabaseHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(TABLE_MEMBER_CREATE);
        db.execSQL(TABLE_SCORE_CREATE);
        this.db = db;

    }

    public String checkSignUp (Contact t) {
        db = this.getReadableDatabase();
        ContentValues values = new ContentValues();

        values.put(CHECK_SIGNCODE, t.getCheckSignCode());

        db = this.getReadableDatabase();
        String query = "select studentCode from " + TABLE_MEMBERS;
        Cursor cursor = db.rawQuery(query, null);
        String signUpCheck, signUpFail = "signUpFail";

        if (cursor.moveToFirst()) {

            do {

                 signUpCheck = cursor.getString(0);


                if (signUpCheck.equals(CHECK_SIGNCODE)) {
                    break;
                }

            } while (cursor.moveToNext());
        }

        return signUpFail;
    }

    public void insertContact(Contact c) {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

//        String query = "select * from members";
//        Cursor cursor = db.rawQuery(query, null);
//        int count = cursor.getCount();
//
//        values.put(COLUMN_MEMBER_ID, count);
        values.put(COLUMN_MEMBER_NAME, c.getName());
        values.put(COLUMN_MEMBER_SURNAME, c.getSurname());
        values.put(COLUMN_MEMBER_STUDENT_CODE, c.getStdCode());
        values.put(COLUMN_MEMBER_TEACHER_NAME, c.getTeacherName());

        db.insert(TABLE_MEMBERS, null, values);
        db.close();

    }

    public String searchPass(String name) {

        db = this.getReadableDatabase();
        String query = "select name, studentcode from " + TABLE_MEMBERS;
        Cursor cursor = db.rawQuery(query, null);

        String nameLoginString,codeLoginString;
                codeLoginString = "not found";

        if (cursor.moveToFirst()) {

            do {

                nameLoginString = cursor.getString(0);


                if (nameLoginString.equals(name)) {
                    codeLoginString = cursor.getString(1);

                    break;
                }

            } while (cursor.moveToNext());
        }

        return codeLoginString;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String query = "DROP TABLE IF EXISTS " + TABLE_MEMBERS;
        db.execSQL(query);
        this.onCreate(db);

    }

}
