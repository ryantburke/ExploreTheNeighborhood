package com.burke.explore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    private Button btnEnter;
    private MediaPlayer mpSoundtrack;
    private EditText etName;
    private ImageView[] ivCharacter;
    private ImageView ivPlayer;


    private Button btnExplore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEnter = findViewById(R.id.enter_button);

        mpSoundtrack = MediaPlayer.create(MainActivity.this,R.raw.title_track);
        mpSoundtrack.start();
        mpSoundtrack.setLooping(true);



        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.choose_character_layout);
                btnExplore = findViewById(R.id.btn_explore);
                btnExplore.setVisibility(View.INVISIBLE);
                etName = findViewById(R.id.et_Name);

                ivCharacter = new ImageView[4];
                ivCharacter[0] = findViewById(R.id.iv_character1);
                ivCharacter[0].setImageResource(R.drawable.character1);
                ivCharacter[0].setTag((R.drawable.character1));

                ivCharacter[1] = findViewById(R.id.iv_character2);
                ivCharacter[1].setImageResource(R.drawable.character2);
                ivCharacter[1].setTag((R.drawable.character2));

                ivCharacter[2] = findViewById(R.id.iv_character3);
                ivCharacter[2].setImageResource(R.drawable.character3);
                ivCharacter[2].setTag((R.drawable.character3));

                ivCharacter[3] = findViewById(R.id.iv_character4);
                ivCharacter[3].setImageResource(R.drawable.character4);
                ivCharacter[3].setTag((R.drawable.character4));

                for (ImageView image:ivCharacter) {
                    image.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ivPlayer = image;
                            btnExplore.setVisibility(View.VISIBLE);
                        }
                    });
                }




                btnExplore.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        mpSoundtrack.stop();

                        Player player = new Player(etName.getText().toString(),(Integer) ivPlayer.getTag());

                        Intent intentNeighborhood = new Intent(MainActivity.this,HauntedHouseActivity.class);

                        intentNeighborhood.putExtra("player", (Serializable) player);
                        startActivity(intentNeighborhood);

                    }
                });

            }
        });





    }
}