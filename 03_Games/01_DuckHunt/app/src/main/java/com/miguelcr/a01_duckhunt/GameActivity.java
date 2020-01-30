package com.miguelcr.a01_duckhunt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvNick, tvCounter, tvTimer;
    ImageView duck;
    int counter = 0;
    boolean gameOver = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        tvNick = findViewById(R.id.textViewNick);
        duck = findViewById(R.id.imageViewDuck);
        tvCounter = findViewById(R.id.textViewCounter);
        tvTimer = findViewById(R.id.textViewTimer);

        // Get the nick
        Bundle extras = getIntent().getExtras();
        String nick = extras.getString("username");

        // Set the nick into the TextView
        tvNick.setText(nick);

        // Click on duck
        duck.setOnClickListener(this);

        // hide the toolbar
        getSupportActionBar().hide();

        // random duck
        moveDuck();
        startCountDown();
    }

    private void startCountDown() {
        new CountDownTimer(60000, 1000) {

            public void onTick(long millisUntilFinished) {
                tvTimer.setText(millisUntilFinished / 1000 + "s");
            }

            public void onFinish() {
                tvTimer.setText("Game over!");
                gameOver = true;
            }
        }.start();
    }
    
    @Override
    public void onClick(View v) {
        if(gameOver) {
            Toast.makeText(this, "The game is over!", Toast.LENGTH_SHORT).show();
        } else {
            counter++;
            tvCounter.setText(String.valueOf(counter));
            moveDuck();
        }
    }

    private void moveDuck() {
        WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        int screenWidth = metrics.widthPixels;
        int screenHeight = metrics.heightPixels;

        // Random coordinates for duck
        Random rn = new Random();

        // Random X
        int maximumX = screenWidth - duck.getWidth();
        int randomX =  rn.nextInt(maximumX - 0 + 1) + 0;

        // Random Y
        int maximumY = screenHeight - duck.getHeight();
        int randomY =  rn.nextInt(maximumY - 0 + 1) + 0;

        // Move the duck
        duck.setX(randomX);
        duck.setY(randomY);

    }
}
