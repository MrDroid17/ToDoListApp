package com.example.android.todolist.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;
import android.util.Log;


@Database(entities = {TaskEntry.class}, version = 1, exportSchema = false)
@TypeConverters(DateConverter.class)
public abstract class TaskDatabase extends RoomDatabase {

    private static final String LOG_TAG = TaskDatabase.class.getSimpleName();
    private static final String DATABASE_NAME = "todolist";
    private static final Object LOCK = new Object();
    private static TaskDatabase ourInstance;

    public static TaskDatabase getInstance(Context context) {
        if (ourInstance == null) {
            synchronized (LOCK){
                Log.d(LOG_TAG, "Creating new Database Instance");

                ourInstance = Room.databaseBuilder(
                        context.getApplicationContext(),
                        TaskDatabase.class,
                        TaskDatabase.DATABASE_NAME)
                        /***
                         * query should be done in seperate thread to avoid locking of main UI thread
                         * this is only temporarily to see if db is working
                         */
                        .allowMainThreadQueries()
                        .build();
            }
        }

        Log.d(LOG_TAG, "getInstance: Getting database instance");
        return ourInstance;
    }

    public abstract TaskDao taskDao();
}
