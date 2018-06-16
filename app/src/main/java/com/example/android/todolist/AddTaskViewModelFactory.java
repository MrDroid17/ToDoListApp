package com.example.android.todolist;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.android.todolist.database.TaskDatabase;

public class AddTaskViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final TaskDatabase mTaskDatabase;

    private final int mTaskID;

    public AddTaskViewModelFactory(TaskDatabase mTaskDatabase, int mTaskID) {
        this.mTaskDatabase = mTaskDatabase;
        this.mTaskID = mTaskID;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new AddTaskViewModel(mTaskDatabase, mTaskID);
    }
}
