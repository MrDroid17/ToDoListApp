package com.example.android.todolist.database;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface TaskDao {

    @Query("SELECT * FROM taskListTable ORDER BY priority")
    List<TaskEntry>  loadAllTasks();

    @Insert
    void insertEntry(TaskEntry taskEntry);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateEntry(TaskEntry taskEntry);

    @Delete
    void deleteEntry(TaskEntry taskEntry);

}