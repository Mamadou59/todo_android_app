package com.openclassrooms.initialtodo.controllers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.openclassrooms.initialtodo.R;
import com.openclassrooms.initialtodo.models.Todo;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private LiveData<List<Todo>> mListLiveData;
    private TodoSelected mTodoSelected;

    public MyAdapter(LiveData<List<Todo>> mySampleData, TodoSelected todoSelected){
        mListLiveData = mySampleData;
        mTodoSelected = todoSelected;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_layout, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mTitle.setText(mListLiveData.getValue().get(position).getTitle());
        holder.mDate.setText(mListLiveData.getValue().get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return mListLiveData.getValue().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTitle;
        public TextView mDate;
        public View layout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView;
            mTitle = (TextView) itemView.findViewById(R.id.todo_title);
            mDate = (TextView) itemView.findViewById(R.id.todo_date);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mTodoSelected.displayTodoSelected(mListLiveData.getValue().get(getAdapterPosition()));
                }
            });
        }
    }

    public interface TodoSelected {
        public void displayTodoSelected(Todo todo);
    }
}
