package com.burke.explore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button enter;
    MediaPlayer soundtrack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enter = findViewById(R.id.enter_button);

        soundtrack = MediaPlayer.create(MainActivity.this,R.raw.title_track);
        soundtrack.start();
        soundtrack.setLooping(true);

        Intent intentExplore = new Intent(this,HauntedHouseActivity.class);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundtrack.stop();
                startActivity(intentExplore);
            }
        });



    }
}