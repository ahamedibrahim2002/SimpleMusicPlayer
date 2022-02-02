package com.example.simplemusicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{
    Button start,stop,pause,resume;
    MediaPlayer musicPlayer;
    int position=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start=findViewById(R.id.start);
        stop=findViewById(R.id.stop);
        pause=findViewById(R.id.pause);
        resume=findViewById(R.id.resume);

        musicPlayer=MediaPlayer.create(this,R.raw.bheem);

        start.setOnClickListener(v-> musicPlayer.start());
        stop.setOnClickListener(v->{
            musicPlayer.stop();
            musicPlayer=MediaPlayer.create(this,R.raw.bheem);
        });
        pause.setOnClickListener(v->{
            position=musicPlayer.getCurrentPosition();
            musicPlayer.pause();
        });
        resume.setOnClickListener(v->{
            musicPlayer.seekTo(position);
            musicPlayer.start();
        });
    }
}