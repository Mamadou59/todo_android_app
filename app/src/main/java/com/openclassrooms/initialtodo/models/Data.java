package com.openclassrooms.initialtodo.models;

import java.util.ArrayList;
import java.util.List;

public class Data {

    //Static class
    private Data(){}

    public static class TodoSampleData {
        public static List<Todo> sTodos = new ArrayList<Todo>();

        public static void fillData(){
            for (int i = 1; i <= 12; i++) {
                sTodos.add(new Todo(i+"/"+i+"/2020", "Todo"+i,"This is the content of Todo "+i, "Author"+i ));
            }
        }


    }
}
