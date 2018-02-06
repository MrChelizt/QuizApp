package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Answer six is mandatory, if it is not correctly filled it displays second Toast; if it is filled correctly than it calculates the final score and shows it to user
     */
    public void submitQuiz(View view) {

        if (answerSix()) {
            int score = 0;

            if (answerOne()) {
                score = score + 1;
            }

            if (answerTwo()) {
                score = score + 1;
            }

            if (answerThree()) {
                score = score + 1;
            }

            if (answerFour()) {
                score = score + 1;
            }

            if (answerFive()) {
                score = score + 1;
            }

            Toast.makeText(this, "You scored " + score + "/5!", Toast.LENGTH_LONG).show();

        } else {

            Toast.makeText(this, "Please correctly enter captcha to see your score", Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * Checks if the correct button is clicked
     */
    private boolean answerOne() {

        RadioButton answer = findViewById(R.id.answer1);
        return answer.isChecked();
    }

    /**
     * Checks if the correct button is clicked
     */
    private boolean answerTwo() {

        RadioButton answer = findViewById(R.id.answer2);
        return answer.isChecked();
    }

    /**
     * Checks if the correct button is clicked
     */
    private boolean answerThree() {

        RadioButton answer = findViewById(R.id.answer3);
        return answer.isChecked();
    }

    /**
     * Checks if the correct buttons are clicked and the others are not
     */
    private boolean answerFour() {

        CheckBox c1 = findViewById(R.id.checkBox1);
        boolean a1 = c1.isChecked();

        CheckBox c2 = findViewById(R.id.checkBox2);//true
        boolean a2 = c2.isChecked();

        CheckBox c3 = findViewById(R.id.checkBox3);
        boolean a3 = c3.isChecked();

        CheckBox c4 = findViewById(R.id.checkBox4);
        boolean a4 = c4.isChecked();

        CheckBox c5 = findViewById(R.id.checkBox5);
        boolean a5 = c5.isChecked();

        CheckBox c6 = findViewById(R.id.checkBox6);//true
        boolean a6 = c6.isChecked();

        if (!a1 && a2 && !a3 && !a4 && !a5 && a6) {
            return true;
        }
        return false;

    }

    /**
     * Checks if the correct button is clicked
     */
    private boolean answerFive() {

        RadioButton answer = findViewById(R.id.answer5);
        return answer.isChecked();
    }

    /**
     * Checks if the user input is same as the text in image
     */
    private boolean answerSix() {

        String correct = "udacity quizApp";

        EditText answer = findViewById(R.id.answer6);
        String userInput = answer.getText().toString();

        if (correct.equals(userInput)) {
            return true;
        }
        return false;
    }
}
