package com.example.administrator.recyclerviewandcardview.model;

/**
 * Created by Administrator on 10/24/2017.
 */

public class Album {
    private String name;
    private int numberOfSong;
    private int resId;

    public Album() {
    }

    public Album(String name, int numberOfSong, int resId) {
        this.name = name;
        this.numberOfSong = numberOfSong;
        this.resId = resId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfSong() {
        return numberOfSong;
    }

    public void setNumberOfSong(int numberOfSong) {
        this.numberOfSong = numberOfSong;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
