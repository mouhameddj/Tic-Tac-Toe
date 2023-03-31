package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class gamelauncher extends AppCompatActivity {
    private tictactoeboard tictactoeboard;
    Button playagain,home;
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
           playerTurn.setText(playerNames[0]+"'s Turn");
       }
        tictactoeboard.setUpGame(playagain,home,playerTurn,playerNames);
        home.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(gamelauncher.this, MainActivity.class));
            }  }));
        playagain.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
      tictactoeboard.resetGame();
      tictactoeboard.invalidate();
            }}));
            }
    }
