package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class gamelauncher extends AppCompatActivity {
    private tictactoeboard tictactoeboard;
    ImageButton playagain;
    ImageButton home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamelauncher);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        tictactoeboard=findViewById(R.id.tictactoeboard);
        playagain= findViewById(R.id.playagain);
        home= findViewById(R.id.home);
        TextView playerTurn=findViewById(R.id.player_display);
        playagain.setVisibility(View.GONE);
        home.setVisibility(View.GONE);
        String [] playerNames =getIntent().getStringArrayExtra("player_names");
       if(playerNames!=null){
           playerTurn.setText(playerNames[0] + " Turn");

// Define a new AlphaAnimation object to create a fade-in animation
           AlphaAnimation fadeInAnimation = new AlphaAnimation(0.0f, 1.0f);
           fadeInAnimation.setDuration(1000); // Set the duration of the animation in milliseconds

// Set the animation listener to remove the view once the animation has ended
           fadeInAnimation.setAnimationListener(new Animation.AnimationListener() {
               @Override
               public void onAnimationStart(Animation animation) {}

               @Override
               public void onAnimationEnd(Animation animation) {
                   playerTurn.setVisibility(View.VISIBLE); // Set the visibility of the view to VISIBLE once the animation has ended
               }

               @Override
               public void onAnimationRepeat(Animation animation) {}
           });

// Start the animation on the playerTurn TextView
           playerTurn.startAnimation(fadeInAnimation);
       }
        tictactoeboard.setUpGame(playagain,home,playerTurn,playerNames);
        home.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(gamelauncher.this, playersetup.class));
            }  }));
        playagain.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
      tictactoeboard.resetGame();
      tictactoeboard.invalidate();
            }}));
            }
    }
