package com.example.james.gpa_jamespina_calculator;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView computeGrade;
    EditText grd1, grd2, grd3, grd4, grd5;
    LinearLayout bgColorH, bgColorV;
    Button computeButton, clearButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assigning variables to IDs stored in activity_main.xml
        grd1 = findViewById(R.id.grade1);
        grd2 = findViewById(R.id.grade2);
        grd3 = findViewById(R.id.grade3);
        grd4 = findViewById(R.id.grade4);
        grd5 = findViewById(R.id.grade5);
        computeGrade = findViewById(R.id.finalGrade);
        bgColorH = findViewById(R.id.backgroundColorH);
        bgColorV = findViewById(R.id.backgroundColorV);
        computeButton = findViewById(R.id.btn_gpaCalc);
        clearButton = findViewById(R.id.btn_clear);

    }

    public void clearGPA(View view) {

        //Clearing output, grade fields, and background
        grd1.setText("");
        grd2.setText("");
        grd3.setText("");
        grd4.setText("");
        grd5.setText("");
        //Making Clear button invisible and the Compute GPA button visible again
        computeButton.setVisibility(View.VISIBLE);
        clearButton.setVisibility(View.INVISIBLE);
        computeGrade.setText(" ");
        bgColorH.setBackgroundColor(Color.WHITE);
        bgColorV.setBackgroundColor(Color.WHITE);

    }

    public void calculateGPA(View view) {

        // try-catch for data validation, to ensure the number is not a string/character
        try {

            //If statement for data validation, all numbers to be between 0 and 100
            if ((Float.parseFloat(grd1.getText().toString().trim()) >= 0) && (Float.parseFloat(grd1.getText().toString().trim()) <= 100) &&
                    (Float.parseFloat(grd2.getText().toString().trim()) >= 0) && (Float.parseFloat(grd2.getText().toString().trim()) <= 100) &&
                    (Float.parseFloat(grd3.getText().toString().trim()) >= 0) && (Float.parseFloat(grd3.getText().toString().trim()) <= 100) &&
                    (Float.parseFloat(grd4.getText().toString().trim()) >= 0) && (Float.parseFloat(grd4.getText().toString().trim()) <= 100) &&
                    (Float.parseFloat(grd5.getText().toString().trim()) >= 0) && (Float.parseFloat(grd5.getText().toString().trim()) <= 100))

            {   //After data validation, the average is calculated and stored in calculateGpa
                float calculateGpa = ((Float.parseFloat(grd1.getText().toString().trim()) +
                        Float.parseFloat(grd2.getText().toString().trim()) +
                        Float.parseFloat(grd3.getText().toString().trim()) +
                        Float.parseFloat(grd4.getText().toString().trim()) +
                        Float.parseFloat(grd5.getText().toString().trim())) / 5);

                //Setting the output of the text below Compute GPA button
                computeGrade.setText("Your GPA is: " + Float.toString(calculateGpa));

                //Setting both the vertical and horizontal colors according to the number stored in calculateGpa
                // 0-59 = RED, 60-79 = YELLOW, 80-100 = GREEN, Invalid Input = WHITE
                if (calculateGpa < 60) {
                    bgColorH.setBackgroundColor(Color.RED);
                    bgColorV.setBackgroundColor(Color.RED);
                } else if (calculateGpa >= 60 && calculateGpa < 80) {
                    bgColorH.setBackgroundColor(Color.YELLOW);
                    bgColorV.setBackgroundColor(Color.YELLOW);
                } else if (calculateGpa >= 80 && calculateGpa <= 100) {
                    bgColorH.setBackgroundColor(Color.GREEN);
                    bgColorV.setBackgroundColor(Color.GREEN);
                } else {
                    bgColorH.setBackgroundColor(Color.WHITE);
                    bgColorV.setBackgroundColor(Color.WHITE);
                }
            } else {
                computeGrade.setText("Invalid input");
                bgColorH.setBackgroundColor(Color.WHITE);
                bgColorV.setBackgroundColor(Color.WHITE);
            }
            //Setting visibility of button so after it is clicked, the "Compute GPA" button disappears and the "Clear" button appears
            computeButton.setVisibility(View.INVISIBLE);
            clearButton.setVisibility(View.VISIBLE);

            //If a value in any of the Grade fields is non-numeric, it will catch the error instead of crashing
            //Then it simply defaults the background to WHITE and makes the Clear button visible
        } catch (NumberFormatException e) {
            computeGrade.setText("Invalid input");
            bgColorH.setBackgroundColor(Color.WHITE);
            bgColorV.setBackgroundColor(Color.WHITE);
            computeButton.setVisibility(View.INVISIBLE);
            clearButton.setVisibility(View.VISIBLE);

        }


    }


}
