package com.miguelcr.a02_tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvPlayer1, tvPlayer2;
    ImageView ivCell0, ivCell1, ivCell2, ivCell3, ivCell4, ivCell5, ivCell6, ivCell7, ivCell8;
    boolean isPlayingPlayerOne = true;
    String name1, name2;
    boolean gameOver = false;

    /*

        By default all the cells are free

        0  |  0  |  0
        -------------
        0  |  0  |  0
        -------------
        0  |  0  |  0

        We have these cells numbers

        0  |  1  |  2
        -------------
        3  |  4  |  5
        -------------
        6  |  7  |  8


     */



    int[] selectedCells = {0,0,0,0,0,0,0,0};
    // 0 > cell is free
    // 1 > player 1
    // 2 > player 2

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        tvPlayer1 = findViewById(R.id.textViewPlayer1);
        tvPlayer2 = findViewById(R.id.textViewPlayer2);

        // get the nicks from the Intent object
        Bundle extras = getIntent().getExtras();
        name1 = extras.getString("P1");
        name2 = extras.getString("P2");
        tvPlayer1.setText(name1);
        tvPlayer2.setText(name2);

        ivCell0 = findViewById(R.id.imageView0);
        ivCell1 = findViewById(R.id.imageView1);
        ivCell2 = findViewById(R.id.imageView2);
        ivCell3 = findViewById(R.id.imageView3);
        ivCell4 = findViewById(R.id.imageView4);
        ivCell5 = findViewById(R.id.imageView5);
        ivCell6 = findViewById(R.id.imageView6);
        ivCell7 = findViewById(R.id.imageView7);
        ivCell8 = findViewById(R.id.imageView8);

        ivCell0.setOnClickListener(this);
        ivCell1.setOnClickListener(this);
        ivCell2.setOnClickListener(this);
        ivCell3.setOnClickListener(this);
        ivCell4.setOnClickListener(this);
        ivCell5.setOnClickListener(this);
        ivCell6.setOnClickListener(this);
        ivCell7.setOnClickListener(this);
        ivCell8.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(gameOver) {
            Toast.makeText(this, "Game is over!", Toast.LENGTH_SHORT).show();
        } else {
            int id = v.getId();

            ImageView ivClicked = (ImageView) v;

            int position = 0;

            switch (id) {
                case R.id.imageView0:
                    position = 0;
                    break;
                case R.id.imageView1:
                    position = 1;
                    break;
                case R.id.imageView2:
                    position = 2;
                    break;
                case R.id.imageView3:
                    position = 3;
                    break;
                case R.id.imageView4:
                    position = 4;
                    break;
                case R.id.imageView5:
                    position = 5;
                    break;
                case R.id.imageView6:
                    position = 6;
                    break;
                case R.id.imageView7:
                    position = 7;
                    break;
                case R.id.imageView8:
                    position = 8;
                    break;
            }

            if(selectedCells[position] != 0) {
                Toast.makeText(this, "The cell is not empty!", Toast.LENGTH_SHORT).show();
            } else {

                // Change image that appear in the cell
                if (isPlayingPlayerOne) {
                    selectedCells[position] = 1;
                    ivClicked.setImageResource(R.drawable.ic_player_one);
                } else { // player 2 is playing
                    selectedCells[position] = 2;
                    ivClicked.setImageResource(R.drawable.ic_player_two);
                }

                if(checkWinner()) {
                    gameOver = true;
                    if(isPlayingPlayerOne) {
                        Toast.makeText(this, name1 + " wins!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, name2 + " wins!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    isPlayingPlayerOne = !isPlayingPlayerOne;
                }
            }
        }

    }

    private boolean checkWinner() {
        boolean existSolution = false;

        if(selectedCells[0] == selectedCells[1]
                && selectedCells[1] == selectedCells[2]
                && selectedCells[2] != 0) {
            existSolution = true;
        } else if(selectedCells[3] == selectedCells[4]
                && selectedCells[4] == selectedCells[5]
                && selectedCells[5] != 0) {
            existSolution = true;
        }

        return existSolution;
    }
}
