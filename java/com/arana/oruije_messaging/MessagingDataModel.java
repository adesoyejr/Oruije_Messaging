package com.arana.oruije_messaging;

import android.graphics.Bitmap;

import de.hdodenhof.circleimageview.CircleImageView;

public class MessagingDataModel {
    String name, position, time, super_button, message, friend_id;
    Bitmap user_image;

    public MessagingDataModel(String name, String position, String time, String message, String super_button, Bitmap user_image ,String friend_id) {
        this.name=name;
        this.position=position;
        this.time=time;
        this.super_button=super_button;
        this.message=message;
        this.user_image=user_image;
        this.friend_id=friend_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSuper_button() {
        return super_button;
    }

    public void setSuper_button(String super_button) {
        this.super_button = super_button;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Bitmap getUser_image() {
        return user_image;
    }

    public void setUser_image(Bitmap user_image) {
        this.user_image = user_image;
    }

    public String getFriend_id() {
        return friend_id;
    }

    public void setFriend_id(String friend_id) {
        this.friend_id = friend_id;
    }
}
