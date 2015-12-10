package com.caocm.android.quiz.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by caocm_000 on 12/10/2015.
 */
public class QuizDatabaseHelper extends SQLiteOpenHelper{

    private static String DB_NAME = "quizz";
    private static int DB_VERSION = 1;

    public QuizDatabaseHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE QUESTIONS (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "QUSTIONBODY TEXT," +
                "ANSWER INTEGER" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
