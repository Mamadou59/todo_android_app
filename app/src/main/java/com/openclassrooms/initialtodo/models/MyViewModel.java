package com.openclassrooms.initialtodo.models;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class MyViewModel  extends ViewModel {
    private MutableLiveData<List<Todo>> sampleLiveData;
    public LiveData<List<Todo>> getSampleData(){
        if (sampleLiveData == null){
            Data.TodoSampleData.fillData();
            sampleLiveData = new MutableLiveData<List<Todo>>();
            sampleLiveData.setValue(Data.TodoSampleData.sTodos);
        }
        return sampleLiveData;
    }
}
