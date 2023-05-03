package com.burke.explore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.Context;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class HauntedHouseActivity extends ExploreActivity {

    @Override
    public void initialize(){
        setContentView(R.layout.haunted_house);
        //initialize house and adjacent rooms
        Room[] rooms = new Room[11];
        //room                room name       array of connected rooms          button                            image                           description
        rooms[0]  = new Room("Entry Hallway",   new int[] {1,2},         findViewById(R.id.entry_hallway),  R.drawable.houseexplore,"Time to explore the house! Where to go...");
        rooms[1]  = new Room("Fourier",         new int[] {0,3,5,6},     findViewById(R.id.fourier),        R.drawable.houseexplore,"This family is gone, the house appears to be tidy. What comes next?");
        rooms[2]  = new Room("Garage",          new int[] {0,5},         findViewById(R.id.garage),         R.drawable.houseexplore,"The car is gone, perfect, we have time to explore!");
        rooms[3]  = new Room("Kitchen",         new int[] {4,1},         findViewById(R.id.kitchen),        R.drawable.houseexplore,"Is that a chewy bar on the counter? Finders keepers!");
        rooms[4]  = new Room("Pantry",          new int[] {3},           findViewById(R.id.pantry),         R.drawable.houseexplore,"So many cans of tuna! Good thing I brought my can opener.");
        rooms[5]  = new Room("Living Room",     new int[] {2,1,10},      findViewById(R.id.living_room),    R.drawable.houseexplore,"Lets watch some Breaking Bad!");
        rooms[6]  = new Room("Cobwebb Hallway", new int[] {1,7,8,9,10},  findViewById(R.id.hallway),        R.drawable.houseexplore,"The light doesn't work, good! Looks like I won't get caught!");
        rooms[7]  = new Room("Spooky Bunkroom", new int[] {6},           findViewById(R.id.bunkroom),       R.drawable.houseexplore,"Cute pictures of kids, maybe I'll take a picture to take with me!");
        rooms[8]  = new Room("Nursery",         new int[] {6},           findViewById(R.id.nursery),        R.drawable.houseexplore,"A baby! Guess I'm not alone here.");
        rooms[9]  = new Room("Master Bedroom",  new int[] {6,10},        findViewById(R.id.master_bedroom), R.drawable.houseexplore,"Clean sheets! Maybe I'll take a nap.");
        rooms[10] = new Room("Backyard",        new int[] {1,5,6,9},     findViewById(R.id.backyard),       R.drawable.houseexplore,"No dog! Shoot, most houses I explore have a dog. Now I feel lonely.");
        house = new House("Haunted House", rooms);
        currentRoom = house.getRooms()[0];

        //initialize text
        tvRoomName = findViewById(R.id.room_name);
        tvDescription = findViewById(R.id.room_description);

        ivMainImage = findViewById(R.id.iv_main_image);
        ivMainImage.setImageResource(R.drawable.haunted_house);
        character = findViewById(R.id.character);

    }

}