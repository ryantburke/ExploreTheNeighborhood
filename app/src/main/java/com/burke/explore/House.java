package com.burke.explore;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class House {


    private String name;
    private Player player;
    private Room[] rooms;

    public House(String name, Room[] rooms) {
        this.name = name;
        this.rooms = rooms;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Room[] getRooms() {
        return rooms;
    }

    public void setRooms(Room[] rooms) {
        this.rooms = rooms;
    }

    public void update(Room currentRoom){

        int[] adjacentRoomsIDs = currentRoom.getAdjacentRoomsIDs();

        for (Room room:rooms){
            room.getButton().setVisibility(View.INVISIBLE);
        }

        for(int i=0; i< adjacentRoomsIDs.length; i++){
            Button button = rooms[adjacentRoomsIDs[i]].getButton();

            //button.setText(adjacentRoomsIDs[i].getName());
            button.setVisibility(View.VISIBLE);

            /*
            int width = button.getWidth();
            int height = button.getHeight();
            button.setLayoutParams(new LinearLayout.LayoutParams(width,height));
            */
        }
    }

}
