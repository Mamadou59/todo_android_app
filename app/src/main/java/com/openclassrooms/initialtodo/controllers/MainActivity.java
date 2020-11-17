package com.openclassrooms.initialtodo.controllers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.openclassrooms.initialtodo.R;
import com.openclassrooms.initialtodo.models.MyViewModel;
import com.openclassrooms.initialtodo.models.Todo;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MyAdapter.TodoSelected,
        View.OnClickListener,
        AddTodoDialogFragment.TodoNoticeDialogListener,
        RecyclerItemTouchHelper.RecyclerItemTouchHelperListener {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ImageView mAddButton;
    private MyViewModel mTodoViewModel;
    private AddTodoDialogFragment mAddTodoDialogFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mTodoViewModel = new ViewModelProvider(this).get(MyViewModel.class);
        mAdapter = new MyAdapter(mTodoViewModel.getSampleData(), this);
        mRecyclerView.setAdapter(mAdapter);

        mAddTodoDialogFragment = new AddTodoDialogFragment();
        //Add button
        mAddButton = (ImageView) findViewById(R.id.add_todo);
        mAddButton.setOnClickListener(this);

        // removing item by swipe

        ItemTouchHelper.SimpleCallback recyclerItemTouchHelper = new RecyclerItemTouchHelper(
                0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT,
                this);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(recyclerItemTouchHelper);
        itemTouchHelper.attachToRecyclerView(mRecyclerView);



    }


    @Override
    public void displayTodoSelected(Todo todo) {
        startActivity(new Intent(this, DetailActivity.class).putExtra("todo", todo));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_todo:{
                mAddTodoDialogFragment.show(getSupportFragmentManager(),"add todo");
            }
            break;
        }
    }

    @SuppressLint("ResourceType")
    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
        Dialog v = dialog.getDialog();
        EditText title = (EditText) v.findViewById(R.id.todo_new_title);
        EditText author = (EditText) v.findViewById(R.id.todo_new_author);
        EditText date = (EditText) v.findViewById(R.id.todo_new_date);
        EditText content = (EditText) v.findViewById(R.id.todo_new_content);
        //Only View model have access to todoList
        mTodoViewModel.addTodo(date.getText().toString(), title.getText().toString(), content.getText().toString(), author.getText().toString());
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder) {
        int position = viewHolder.getAdapterPosition();
        mTodoViewModel.removeTodo(position);
        mAdapter.notifyItemRemoved(position);
    }
}