package com.burke.explore;

import android.widget.ImageView;

import java.io.Serializable;

public class Player implements Serializable {

    private String name;
    private ImageView image;
    private int numHousesExplored;

    private int numTimesCaught;

    public Player(String name, ImageView image) {
        this.name = name;
        this.image = image;
        this.numHousesExplored = 0;
        this.numTimesCaught = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    public int getNumHousesExplored() {
        return numHousesExplored;
    }

    public void setNumHousesExplored(int numHousesExplored) {
        this.numHousesExplored = numHousesExplored;
    }

    public int getNumTimesCaught() {
        return numTimesCaught;
    }

    public void setNumTimesCaught(int numTimesCaught) {
        this.numTimesCaught = numTimesCaught;
    }
}
