package com.udacity.test.habittracker.sanchitsharma.habittrackersanchitudacity;

import android.provider.BaseColumns;

/**
 * Created by sanchitsharma on 10/29/17.
 */

public class DBContractClass {
    private DBContractClass(){}
    public class Habits implements BaseColumns {
        public static final String Table_Name = "HABITS";
        public static final String HabitName = "habit";
        public static final String HabitOccuranceCount = "count";
        public static final String HabitOccuranceDate = "date";

    }

}
