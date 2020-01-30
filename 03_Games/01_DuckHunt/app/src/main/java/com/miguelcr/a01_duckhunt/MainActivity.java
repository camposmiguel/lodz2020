package com.miguelcr.a01_duckhunt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etNick;
    Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNick = findViewById(R.id.editTextNick);
        btnStart = findViewById(R.id.buttonStart);

        // Click
        btnStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String nick = etNick.getText().toString();

        if(nick.isEmpty()) {
            etNick.setError("Write a nick please!");
        } else {
            // open the game
            Intent i = new Intent(this, GameActivity.class);

            i.putExtra("username", nick);

            startActivity(i);
        }
    }
}
