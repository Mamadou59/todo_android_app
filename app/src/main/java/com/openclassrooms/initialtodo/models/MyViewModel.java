package com.openclassrooms.initialtodo.models;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class MyViewModel  extends ViewModel {
    TodoDataHolder mTodoDataHolder = TodoDataHolder.getInstance();
    //private MutableLiveData<List<Todo>> sampleLiveData;
    /**public LiveData<List<Todo>> getSampleData(){
        if (sampleLiveData == null){
            TodoDataHolder.TodoSampleData.fillData();
            sampleLiveData = new MutableLiveData<List<Todo>>();
            sampleLiveData.setValue(TodoDataHolder.TodoSampleData.sTodos);
        }
        return sampleLiveData;

    }*/

    public void addTodo(String date, String title, String content, String author) {
        mTodoDataHolder.addTodo(date, title, content, author);
    }
    public void removeTodo(int position) {
        mTodoDataHolder.removeTodo(position);
    }

}
