package com.arana.oruije_messaging;

import android.graphics.Bitmap;

public class ChatListModel {
    String message, date_posted, time_posted, author_id, user_id;
    String has_image,image_message;

    public ChatListModel(String message,String date_posted,String time_posted,String author_id,String user_id,String has_image,String image_message){
        this.message = message;
        this.date_posted = date_posted;
        this.time_posted = time_posted;
        this.author_id = author_id;
        this.user_id = user_id;
        this.has_image = has_image;
        this.image_message = image_message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate_posted() {
        return date_posted;
    }

    public void setDate_posted(String date_posted) {
        this.date_posted = date_posted;
    }

    public String getTime_posted() {
        return time_posted;
    }

    public void setTime_posted(String time_posted) {
        this.time_posted = time_posted;
    }

    public String getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(String author_id) {
        this.author_id = author_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String isHas_image() {
        return has_image;
    }
    public void setHas_image(String has_image) {
        this.has_image = has_image;
    }

    public String getImage_message() {
        return image_message;
    }

    public void setImage_message(String image_message) {
        this.image_message = image_message;
    }
}
