package com.burke.explore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ExploreActivity extends AppCompatActivity {

    protected Player player;
    protected ConstraintLayout houseLayout;
    protected TextView tvRoomName;
    protected TextView tvDescription;
    protected ImageView ivMap;

    protected ImageView ivRoomImage;
    protected ImageView character;

    protected House house;
    protected Room currentRoom;
    protected Room homeownerRoom;

    protected ImageView homeowner;
    protected int homeownerReturnTimeMs = 10000;
    protected int homeownerMoveTimeMs = 2000;

    protected Handler handler = new Handler();
    protected MediaPlayer mp_soundtrack;
    protected MediaPlayer mp_arrivehome;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initialize();
        initializeHouse();
        movePlayer();
        delayedHomeonwerReturn();

    }

    protected void initialize(){

        mp_soundtrack = MediaPlayer.create(this,R.raw.title_track2);
        mp_soundtrack.start();
        mp_soundtrack.setLooping(true);

        mp_arrivehome = MediaPlayer.create(this, R.raw.arrive_home);

    }

    protected void initializeHouse(){

    }


    protected void movePlayer(){
        tvRoomName.setText(currentRoom.getName());
        tvDescription.setText(currentRoom.getDescription());
        ivRoomImage.setImageResource(currentRoom.getImageID());
        house.update(currentRoom);

        ConstraintLayout layout = houseLayout;
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(layout);

        constraintSet.connect(character.getId(), ConstraintSet.START,   currentRoom.getButton().getId(), ConstraintSet.START);
        constraintSet.connect(character.getId(), ConstraintSet.END,     currentRoom.getButton().getId(), ConstraintSet.END);
        constraintSet.connect(character.getId(), ConstraintSet.TOP,     currentRoom.getButton().getId(), ConstraintSet.TOP);
        constraintSet.connect(character.getId(), ConstraintSet.BOTTOM,  currentRoom.getButton().getId(), ConstraintSet.BOTTOM);

        TransitionManager.beginDelayedTransition(layout);
        constraintSet.applyTo(layout);
        character.invalidate();

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

    protected void delayedHomeonwerReturn(){

        homeowner.setVisibility(View.INVISIBLE);

        new Handler().postDelayed(() -> {

            tvRoomName.setText("OH NO!");
            tvDescription.setText("SOMEONE IS HOME! WHAT TO DO!");
            ivRoomImage.setImageResource(R.drawable.homeowner_arrives);
            mp_arrivehome.start();

            homeowner.setVisibility(View.VISIBLE);

            ConstraintLayout layout = houseLayout;
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(houseLayout);

            constraintSet.connect(homeowner.getId(), ConstraintSet.START, currentRoom.getButton().getId(), ConstraintSet.START);
            constraintSet.connect(homeowner.getId(), ConstraintSet.END, currentRoom.getButton().getId(), ConstraintSet.END);
            constraintSet.connect(homeowner.getId(), ConstraintSet.TOP, currentRoom.getButton().getId(), ConstraintSet.TOP);
            constraintSet.connect(homeowner.getId(), ConstraintSet.BOTTOM, currentRoom.getButton().getId(), ConstraintSet.BOTTOM);

            TransitionManager.beginDelayedTransition(layout);
            constraintSet.applyTo(layout);
            homeowner.invalidate();

            Room[] adjacentRooms = homeownerRoom.getAdjacentRooms(house);
            int randRoom = (int) (Math.random() * adjacentRooms.length);
            homeownerRoom = adjacentRooms[randRoom];
            moveHomeowner();

        }, homeownerReturnTimeMs); // delay until homeowner return in milliseconds
    }


    protected void moveHomeowner(){

        ConstraintLayout layout = houseLayout;
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(houseLayout);

        constraintSet.connect(homeowner.getId(), ConstraintSet.START,   homeownerRoom.getButton().getId(), ConstraintSet.START);
        constraintSet.connect(homeowner.getId(), ConstraintSet.END,     homeownerRoom.getButton().getId(), ConstraintSet.END);
        constraintSet.connect(homeowner.getId(), ConstraintSet.TOP,     homeownerRoom.getButton().getId(), ConstraintSet.TOP);
        constraintSet.connect(homeowner.getId(), ConstraintSet.BOTTOM,  homeownerRoom.getButton().getId(), ConstraintSet.BOTTOM);

        TransitionManager.beginDelayedTransition(layout);
        constraintSet.applyTo(layout);
        homeowner.invalidate();

        Room[] adjacentRooms = homeownerRoom.getAdjacentRooms(house);
        int randRoom = (int) (Math.random() * adjacentRooms.length);
        homeownerRoom = adjacentRooms[randRoom];

        handler.postDelayed(() -> moveHomeowner(), homeownerMoveTimeMs); //delay homeowner movement



    }
}