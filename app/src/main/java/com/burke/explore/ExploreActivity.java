package com.burke.explore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.os.Bundle;
import android.os.Handler;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ExploreActivity extends AppCompatActivity {

    protected TextView tvRoomName;
    protected TextView tvDescription;
    protected ImageView ivMap;

    protected ImageView ivRoomImage;
    protected ImageView character;

    protected ImageView homeowner;

    protected House house;
    protected Room currentRoom;
    protected Room homeownerRoom;

    protected Thread thread = new Thread() {
        @Override
        public void run() {
            try {
        ivRoomImage.setImageResource(currentRoom.getImageID());
        house.update(currentRoom);
        movePlayerImage();

        Room[] adjacentRooms = currentRoom.getAdjacentRooms(house);
        for (int i=0; i<adjacentRooms.length; i++){
            final int k = i;
            adjacentRooms[k].getButton().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    currentRoom = adjacentRooms[k];

                    movePlayer();
                }
            });
        }
    }

    private void movePlayerImage(){

        ConstraintLayout layout = findViewById(R.id.haunted_house_layout);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(layout);

        constraintSet.connect(character.getId(), ConstraintSet.START,   currentRoom.getButton().getId(), ConstraintSet.START);
        constraintSet.connect(character.getId(), ConstraintSet.END,     currentRoom.getButton().getId(), ConstraintSet.END);
        constraintSet.connect(character.getId(), ConstraintSet.TOP,     currentRoom.getButton().getId(), ConstraintSet.TOP);
        constraintSet.connect(character.getId(), ConstraintSet.BOTTOM,  currentRoom.getButton().getId(), ConstraintSet.BOTTOM);

        TransitionManager.beginDelayedTransition(layout);
        constraintSet.applyTo(layout);
        character.invalidate();
    }

    private void moveHomeowner(){

        ConstraintLayout layout = findViewById(R.id.haunted_house_layout);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(layout);

        Room[] adjacentRooms = homeownerRoom.getAdjacentRooms(house);
        int randRoom = (int) (Math.random() * homeownerRoom.getAdjacentRoomsIDs().length);
        homeownerRoom = adjacentRooms[randRoom];

        constraintSet.connect(homeowner.getId(), ConstraintSet.START,   homeownerRoom.getButton().getId(), ConstraintSet.START);
        constraintSet.connect(homeowner.getId(), ConstraintSet.END,     homeownerRoom.getButton().getId(), ConstraintSet.END);
        constraintSet.connect(homeowner.getId(), ConstraintSet.TOP,     homeownerRoom.getButton().getId(), ConstraintSet.TOP);
        constraintSet.connect(homeowner.getId(), ConstraintSet.BOTTOM,  homeownerRoom.getButton().getId(), ConstraintSet.BOTTOM);

        TransitionManager.beginDelayedTransition(layout);
        constraintSet.applyTo(layout);
        homeowner.invalidate();
    }
}