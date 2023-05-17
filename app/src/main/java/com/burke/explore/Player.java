package com.burke.explore;

import android.widget.ImageView;

import java.io.Serializable;

public class Player implements Serializable {

    private String name;
    private int imageID;
    private int numHousesExplored;

    private int numTimesCaught;

    public Player(String name, int imageID) {
        this.name = name;
        this.imageID = imageID;
        this.numHousesExplored = 0;
        this.numTimesCaught = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
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
