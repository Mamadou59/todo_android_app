package com.openclassrooms.initialtodo.models;

import java.util.ArrayList;
import java.util.List;

public class TodoDataHolder {

    //Static class
    private TodoDataHolder(){
        mTodos = new ArrayList<Todo>();
        this.fillData();
    }
    private List<Todo> mTodos;
    private static TodoDataHolder mTodoDataHolder;

    public static TodoDataHolder getInstance() {
        if (mTodoDataHolder == null)
            mTodoDataHolder = new TodoDataHolder();
        return mTodoDataHolder;
    }

    private void fillData(){
        for (int i = 1; i <= 12; i++) {
            mTodos.add(new Todo(i+"/"+i+"/2020", "Todo"+i,"This is the content of Todo "+i, "Author"+i ));
        }
    }

    public void addTodo(String date, String title, String content, String author) {
        mTodos.add(new Todo(date, title, content, author));
    }
    public  void removeTodo(int position) {
            mTodos.remove(position);
    }

}
