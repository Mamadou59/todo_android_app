package com.openclassrooms.initialtodo.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.openclassrooms.initialtodo.R;
import com.openclassrooms.initialtodo.models.Todo;

public class DetailActivity extends AppCompatActivity {
    private TextView mTodoTitle;
    private TextView mTodoDate;
    private TextView mTodoAuthor;
    private TextView mTodoContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mTodoTitle = (TextView) findViewById(R.id.todo_detail_title);
        mTodoDate = (TextView) findViewById(R.id.todo_detail_date);
        mTodoAuthor = (TextView) findViewById(R.id.todo_detail_author);
        mTodoContent = (TextView) findViewById(R.id.todo_detail_content);

        Intent intent = getIntent();

        if(intent.getExtras() != null){
            Todo todoSelected = (Todo) intent.getSerializableExtra("todo");
            mTodoTitle.setText(todoSelected.getTitle());
            mTodoDate.setText(todoSelected.getDate());
            mTodoAuthor.setText(todoSelected.getAuthor());
            mTodoContent.setText(todoSelected.getContent());

        }



    }
}