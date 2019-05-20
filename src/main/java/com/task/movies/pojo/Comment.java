package com.task.movies.pojo;

import java.text.SimpleDateFormat;

public class Comment {

    String user;
    String message;
    String dateCreated;
    int like;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDateCreated() {

        Long date = Long.parseLong(dateCreated);
        String formattedDate = new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date (date*1000));

        return formattedDate;
    }

    public void setDateCreated(String dateCreated) {

        this.dateCreated = dateCreated;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }
}
