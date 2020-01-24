package com.miguelcr.a01_simplelist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class StudentDetailActivity extends AppCompatActivity {
    TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail);

        tvName = findViewById(R.id.textViewName);

        // Get the Intent information
        Bundle extras = getIntent().getExtras();

        // Get the student name
        String name = extras.getString("studentName");

        // Set the name into the TextView
        tvName.setText(name);
    }
}
