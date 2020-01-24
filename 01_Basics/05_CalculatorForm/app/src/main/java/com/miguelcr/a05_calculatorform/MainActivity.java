package com.miguelcr.a05_calculatorform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnPlus, btnMinus;
    EditText etOperand1, etOperand2;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etOperand1 = findViewById(R.id.editTextOperand1);
        etOperand2 = findViewById(R.id.editTextOperand2);
        btnMinus = findViewById(R.id.buttonMinus);
        btnPlus = findViewById(R.id.buttonPlus);
        tvResult = findViewById(R.id.textViewResult);

        btnMinus.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        // Get the operand1 and operand2 texts
        String op1 = etOperand1.getText().toString();
        String op2 = etOperand2.getText().toString();

        // Convert String to int
        int operand1 = Integer.parseInt(op1);
        int operand2 = Integer.parseInt(op2);

        if(id == R.id.buttonPlus) {

            int result = operand1 + operand2;
            tvResult.setText("Result: " + result);

        } else if(id == R.id.buttonMinus) {

            int result = operand1 - operand2;
            tvResult.setText("Result: " + result);
        }
    }
}
