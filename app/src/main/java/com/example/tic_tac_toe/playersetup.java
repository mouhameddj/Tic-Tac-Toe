package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class playersetup extends AppCompatActivity {
    Button submmit;
    TextView player1,player2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playersetup);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        submmit= findViewById(R.id.submit);
        player1= findViewById(R.id.player1);
        player2= findViewById(R.id.player2);
        submmit.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String playernum1Name=player1.getText().toString();
                String playernum2Name=player2.getText().toString();
        Intent intent=  new Intent(playersetup.this, gamelauncher.class);
                intent.putExtra("player_names",new String[]{playernum1Name,playernum2Name});
                startActivity(intent);

            }  }));
    }
}