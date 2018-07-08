package com.example.ravishankar.quizapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    public RadioGroup question1Answer;
    public RadioGroup question2Answer;
    public RadioButton answer1;
    public RadioButton answer2;
    CheckBox kotlinCheck;
    CheckBox pythonCheck;
    CheckBox javaCheck;
    CheckBox c_hashCheck;
    Toast toast;
    EditText question3Answer;
    EditText question4Answer;
    public int points;
    int selected1;
    int selected2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void onClick(View view) {
        question1Answer = findViewById(R.id.firstGroup);
        question2Answer = findViewById(R.id.secondGroup);
        if(question1Answer.getCheckedRadioButtonId()!=-1) {
            selected1 = question1Answer.getCheckedRadioButtonId();
            answer1 = findViewById(selected1);
            if (answer1.getText().toString().trim().equalsIgnoreCase("android p")) {
                points += 1;
            }
        }

        if(question2Answer.getCheckedRadioButtonId()!=-1) {
            selected2 = question2Answer.getCheckedRadioButtonId();
            answer2 = findViewById(selected2);
            if (answer2.getText().toString().trim().equalsIgnoreCase("intents"))
                points += 1;
        }

        question3Answer = findViewById(R.id.kernel);
        if (question3Answer.getText().toString().trim().equalsIgnoreCase("linux"))
            points += 1;

        question4Answer = findViewById(R.id.owner);
        if (question4Answer.getText().toString().trim().equalsIgnoreCase("google"))
            points += 1;

        kotlinCheck = findViewById(R.id.choice1);
        pythonCheck=findViewById(R.id.choice2);
        javaCheck = findViewById(R.id.choice3);
        c_hashCheck=findViewById(R.id.choice4);
        if (kotlinCheck.isChecked() &&!pythonCheck.isChecked()&& javaCheck.isChecked()&&!c_hashCheck.isChecked()) {
              points += 1;
        }

        displayToasts(points);
        points=0;
    }

    public void displayToasts(int points)
    {
        Context context=getApplicationContext();
        int time=Toast.LENGTH_SHORT;
        String toast_message;
        if(points==0||points==1)
            {
        toast_message=getString(R.string.comment1)+"\n"+getString(R.string.toast1)+" "+points;
        }
        else if(points==4||points==5)
            {
                toast_message=getString(R.string.comment3)+"\n"+getString(R.string.toast1)+" "+points;
                }
                else
                    {
                        toast_message=getString(R.string.comment2)+"\n"+getString(R.string.toast1)+" "+points;
                        }

        if (toast != null) {
            toast.cancel();
        }
         toast = Toast.makeText(context, toast_message, time);
        toast.show();
    }
}


