package com.example.forster;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class Child {
    public String name,description,image;
    //public ImageView Image;


    public Child() {
    }

    public Child(String name, String description, String image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
