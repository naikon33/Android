package com.example.onlinestore;

import androidx.annotation.NonNull;

public class Laptop {
    private String title;
    private String info;
    private int id;

    public Laptop(String title, String info, int id) {
        this.title = title;
        this.info = info;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getInfo() {
        return info;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return title;
    }
}
