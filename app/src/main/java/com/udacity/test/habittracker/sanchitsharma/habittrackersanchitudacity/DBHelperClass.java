package com.udacity.test.habittracker.sanchitsharma.habittrackersanchitudacity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sanchitsharma on 10/29/17.
 */

public class DBHelperClass extends SQLiteOpenHelper {
    private static final String DB_NAME = "habits.db";
    private static final int DB_VERSION = 1;

    public DBHelperClass(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {

        String createTable = "CREATE TABLE " + DBContractClass.Habits.Table_Name + " ("
                + DBContractClass.Habits.HabitName + " TEXT NOT NULL, "
                + DBContractClass.Habits.HabitOccuranceCount + " INTEGER NOT NULL, "
                + DBContractClass.Habits.HabitOccuranceDate + " TEXT);";

        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DBContractClass.Habits.Table_Name);
        onCreate(db);
    }
}
