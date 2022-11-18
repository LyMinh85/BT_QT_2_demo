package com.example.bt_qt_2;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class Note {
    private String title;
    private Date date;
    private String content;

    public Note(String title, Date date, String content) {
        this.title = title;
        this.date = date;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public String getDateFormat() {
        String pattern = "E MMM d, HH:mm";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
