package com.udacity.test.habittracker.sanchitsharma.habittrackersanchitudacity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private DBHelperClass dbHelper = new DBHelperClass(this); //DB Created via helper class constructor (CURD : Create)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insertHabit("CompleteOverDueUdacityProjects", 2, "29 October 2017");
        insertHabit("TreatOnProjectMeetsSpecification", 1, "28 October 2017");
        insertHabit("Workout", 1, "29 October 2017");
        readHabits();
        deleteAlHabits();
    }



    //CURD : Insert
    public void insertHabit(String habitName, Integer count, String date){

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DBContractClass.Habits.HabitName, habitName);
        values.put(DBContractClass.Habits.HabitOccuranceCount, count );
        values.put(DBContractClass.Habits.HabitOccuranceDate, date );

        db.insertWithOnConflict(DBContractClass.Habits.Table_Name,
                null,
                values,
                SQLiteDatabase.CONFLICT_REPLACE);

        db.close();
    }

    //CURD : Delete
    public void deleteAlHabits() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String deletesql = "delete from " + DBContractClass.Habits.Table_Name;
        db.execSQL(deletesql);
    }

    //CURD : Read
    public void readHabits(){
        try {

            SQLiteDatabase db = dbHelper.getWritableDatabase();

            String querysql= "SELECT * FROM habits";

            Cursor c = db.rawQuery(querysql, null);

            int habit = c.getColumnIndex(DBContractClass.Habits.HabitName);
            int count = c.getColumnIndex(DBContractClass.Habits.HabitOccuranceCount);
            int date = c.getColumnIndex(DBContractClass.Habits.HabitOccuranceDate);

            System.out.println("***********-----------Database--------------************/n");
            if (c != null && c.moveToFirst()){
                do {
                    System.out.println("HabitName :  " + c.getString(habit));
                    System.out.println("HabitOccuranceCount: " + Integer.toString(c.getInt(count)));
                    System.out.println("HabitOccuranceDate : " + c.getString(date));
                    System.out.println("-----------------------------------------------");
                } while(c.moveToNext());
            }

            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
