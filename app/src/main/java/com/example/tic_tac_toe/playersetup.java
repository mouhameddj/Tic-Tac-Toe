package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class playersetup extends AppCompatActivity {
    ImageButton submmit;
    EditText player1,player2;
    TextView ww;

    private static final String TEXT_VIEW_STATE_KEY = "text_view_state_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playersetup);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        submmit= findViewById(R.id.submit);
        player1= findViewById(R.id.player1);
        player2 = findViewById(R.id.player2);
        ww = findViewById(R.id.ww);
        if (savedInstanceState != null) {
            // Restore the text of your TextView from the saved state
            String textViewState = savedInstanceState.getString(TEXT_VIEW_STATE_KEY);
            ww.setText(textViewState);
        } else {
            // Set the initial text of your TextView
            ww.setText("welcome");
        }
        submmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the player names from the EditText views
                String playernum1Name = player1.getText().toString();
                String playernum2Name = player2.getText().toString();

                // Create an intent to launch the gamelauncher activity
                Intent intent = new Intent(playersetup.this, gamelauncher.class);
                intent.putExtra("player_names", new String[]{playernum1Name, playernum2Name});

                // Create and start the fade-out animation for the submmit button
                ObjectAnimator fadeOut = ObjectAnimator.ofFloat(submmit, "alpha", 1f, 0f);
                fadeOut.setDuration(1000); // Set the duration of the animation in milliseconds
                fadeOut.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        // Start the gamelauncher activity after the animation ends
                        startActivity(intent);
                    }
                });
                fadeOut.start();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save the text of your TextView to the Bundle
        outState.putString(TEXT_VIEW_STATE_KEY, ww.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Restore the text of your TextView from the saved state
        String textViewState = savedInstanceState.getString(TEXT_VIEW_STATE_KEY);
        ww.setText(textViewState);
    }
}
