package com.openclassrooms.initialtodo.models;

import java.io.Serializable;
import java.util.Date;

public class Todo implements Serializable {
    private String mDate;
    private String mTitle;
    private String mContent;
    private String mAuthor;

    public String getDate() {
        return mDate;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getContent() {
        return mContent;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public Todo(String date, String title, String content, String author) {
        mDate = date;
        mTitle = title;
        mContent = content;
        mAuthor = author;
    }
}
