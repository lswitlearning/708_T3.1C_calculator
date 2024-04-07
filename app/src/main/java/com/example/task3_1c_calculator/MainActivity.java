package com.example.task3_1c_calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText number1EditText, number2EditText;
    private TextView answerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        number1EditText = findViewById(R.id.number1);
        number2EditText = findViewById(R.id.number2);
        answerTextView = findViewById(R.id.answer);

        Button additionButton = findViewById(R.id.addition);
        Button subtractionButton = findViewById(R.id.subtraction);

        additionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performAddition();
            }
        });

        subtractionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performSubtraction();
            }
        });
    }

    private void performAddition() {
        try {
            double number1 = Double.parseDouble(number1EditText.getText().toString());
            double number2 = Double.parseDouble(number2EditText.getText().toString());
            double result = number1 + number2;
            answerTextView.setText("Result: " + String.valueOf(result));
        } catch (NumberFormatException e) {
            answerTextView.setText("Invalid input");
        }
    }

    private void performSubtraction() {
        try {
            double number1 = Double.parseDouble(number1EditText.getText().toString());
            double number2 = Double.parseDouble(number2EditText.getText().toString());
            double result = number1 - number2;
            answerTextView.setText("Result: " + String.valueOf(result));
        } catch (NumberFormatException e) {
            answerTextView.setText("Invalid input");
        }
    }

}
