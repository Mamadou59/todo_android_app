package com.openclassrooms.initialtodo.controllers;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.openclassrooms.initialtodo.R;
import com.openclassrooms.initialtodo.models.Todo;

public class AddTodoDialogFragment extends DialogFragment {

    TodoNoticeDialogListener listener;
    private Todo mTodo;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.add_new_todo,null))
                .setPositiveButton("Create", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listener.onDialogPositiveClick(AddTodoDialogFragment.this);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        AddTodoDialogFragment.this.getDialog().cancel();
                    }
                });
        return builder.create();

    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (TodoNoticeDialogListener) context;
        }catch (ClassCastException e){
            throw new ClassCastException(getActivity().toString() + "must implement TodoNoticeDialogFragment");
        }
    }


    public interface TodoNoticeDialogListener {
        public void onDialogPositiveClick( DialogFragment dialog);
    }
}
