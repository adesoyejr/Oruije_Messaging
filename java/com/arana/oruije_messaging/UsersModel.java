package com.arana.oruije_messaging;

import android.graphics.Bitmap;

public class UsersModel {
    String name, id, position, category;
    Bitmap user_image;

    public UsersModel(String name, String id, String position, Bitmap user_image, String category) {
        this.name=name;
        this.id=id;
        this.position=position;
        this.category=category;
        this.user_image=user_image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Bitmap getUser_image() {
        return user_image;
    }

    public void setUser_image(Bitmap user_image) {
        this.user_image = user_image;
    }
}
