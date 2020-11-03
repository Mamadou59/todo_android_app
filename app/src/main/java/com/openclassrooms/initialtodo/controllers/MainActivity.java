package com.openclassrooms.initialtodo.controllers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.openclassrooms.initialtodo.R;
import com.openclassrooms.initialtodo.models.MyViewModel;
import com.openclassrooms.initialtodo.models.Todo;

public class MainActivity extends AppCompatActivity implements MyAdapter.TodoSelected{

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MyAdapter(new ViewModelProvider(this).get(MyViewModel.class).getSampleData(), this);
        mRecyclerView.setAdapter(mAdapter);


    }


    @Override
    public void displayTodoSelected(Todo todo) {
        startActivity(new Intent(this, DetailActivity.class).putExtra("todo", todo));
    }
}