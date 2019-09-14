package com.earthquake.newsapp;

import java.util.ArrayList;

public class Items {
    private String title;
    private String description;
    private String time;
    private String image;



    private String url;

    public Items(String title, String description, String time,String image,String url) {
        this.title = title;
        this.description = description;
        this.time = time;
        this.image = image;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
