package com.theodorakyriakou.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /*Calculate user's result and display it as a toast*/
    public void submitResults(View view) {
        int result = 0;
        //check for question 1
        EditText firstanswer = (EditText)findViewById(R.id.first_answer_edit_text);
        String answerone = firstanswer.getText().toString().toLowerCase();
        if (answerone.equals("usa") || answerone.equals("united states of america") || answerone.equals("united states")) {
            result++;
        }
        //check for question 2
        RadioButton rbquestion2 = (RadioButton) findViewById(R.id.second_answer_B_correct);
        if (rbquestion2.isChecked()) {
            result++;
        }
        //check for question 3
        CheckBox[] question3checkbox = new CheckBox[4];
        question3checkbox[0] = (CheckBox) findViewById(R.id.third_answer_one_correct);
        question3checkbox[1]  = (CheckBox) findViewById(R.id.third_answer_two_incorrect);
        question3checkbox[2]  = (CheckBox) findViewById(R.id.third_answer_three_incorrect);
        question3checkbox[3]  = (CheckBox) findViewById(R.id.third_answer_four_correct);
        int count = 0;
        for (int i = 0; i< 4; i++) {
            if ( i == 0 || i == 3) {//if the answers are the correct
                if (question3checkbox[i].isChecked()) {
                    count++;
                }
            }
            else { //if the answers are the incorrect
                if (!(question3checkbox[i].isChecked())) {
                    count++;
                }
            }
        }
        if (count == 4) {//if we have 2 correct checked and two incorrect unchecked
            result++;//count it as a correct answer
        }
        //check for question 4
        RadioButton rbquestion4 = (RadioButton) findViewById(R.id.fourth_answer_A_correct);
        if (rbquestion4.isChecked()) {
            result++;
        }
        //check for question 5
        CheckBox[] question5checkbox = new CheckBox[4];
        question5checkbox[0] = (CheckBox) findViewById(R.id.fifth_answer_one_correct);
        question5checkbox[1]  = (CheckBox) findViewById(R.id.fifth_answer_two_correct);
        question5checkbox[2]  = (CheckBox) findViewById(R.id.fifth_answer_three_correct);
        question5checkbox[3]  = (CheckBox) findViewById(R.id.fifth_answer_four_correct);
        count = 0;
        for (int i = 0; i< 4; i++) {
            if (question5checkbox[i].isChecked()) {
                count++;
            }
        }
        if (count == 4) {
            result++;
        }
        //show the toaster with the final result
        String toastmsg;
        if (result < 5){
            toastmsg = "You got " + result + " out of 5. Better luck next time!";
        }
        else {
            toastmsg = "Congrats! You nailed the UNESCO Quiz!";
        }
        Toast.makeText(MainActivity.this, toastmsg, Toast.LENGTH_LONG).show();
    }
}
