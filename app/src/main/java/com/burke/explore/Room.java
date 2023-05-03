package com.burke.explore;

import android.widget.Button;

public class Room {

    private String name;
    private String description;
    private Button button;
    private int imageID;
    private int[] adjacentRoomsIDs;

    public Room(String name, int[] adjacentRoomsIDs, String description){
        this.name = name;
        this.adjacentRoomsIDs = adjacentRoomsIDs;
        this.description = description;
    }

    public Room(String name, int[] adjacentRoomsIDs, Button button, int imageID, String description){
        this.name = name;
        this.adjacentRoomsIDs = adjacentRoomsIDs;
        this.description = description;
        this.button = button;
        this.imageID = imageID;
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

    public int[] getAdjacentRoomsIDs() {
        return adjacentRoomsIDs;
    }

    public void setAdjacentRoomsIDs(int[] adjacentRooms) {
        this.adjacentRoomsIDs = adjacentRooms;
    }

    public Room[] getAdjacentRooms(House house){
        Room[] adjacentRooms = new Room[adjacentRoomsIDs.length];
        for (int i = 0; i< adjacentRoomsIDs.length; i++){
            adjacentRooms[i] = house.getRooms()[adjacentRoomsIDs[i]];
        }
        return adjacentRooms;
    }

    public Button getButton() {
        return button;
    }

    public int getImageID(){return imageID; }

    public void setButton(Button button) {
        this.button = button;
    }


    public void setImageID(int imageID) {
        this.imageID = imageID;
    }
}
