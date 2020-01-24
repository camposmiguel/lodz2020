package com.miguelcr.a04_loginformvalidation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnLogin;
    EditText etEmail, etPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the reference to the View Components
        btnLogin = findViewById(R.id.buttonLogin);
        etEmail = findViewById(R.id.editTextEmail);
        etPass = findViewById(R.id.editTextPassword);

        // Define the click event
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String email = etEmail.getText().toString();
        String password = etPass.getText().toString();

        if(email.equals("admin@admin.com") && password.equals("1234")) {
            Toast.makeText(this, "Login OK", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Wrong login", Toast.LENGTH_SHORT).show();

            if(email.isEmpty()) {
                etEmail.setError("Write an email");
            } else if(password.isEmpty()) {
                etPass.setError("Write the password");
            }
        }
    }
}
