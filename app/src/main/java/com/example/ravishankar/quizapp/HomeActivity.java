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
    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;
    CheckBox checkBox4;
    Toast toast;
    EditText editText1;
    EditText editText2;
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

        editText1 = findViewById(R.id.kernel);
        if (editText1.getText().toString().equalsIgnoreCase("linux"))
            points += 1;
        editText2 = findViewById(R.id.owner);
        if (editText2.getText().toString().equalsIgnoreCase("google"))
            points += 1;

        checkBox1 = findViewById(R.id.choice1);
        checkBox2=findViewById(R.id.choice2);
        checkBox3 = findViewById(R.id.choice3);
        checkBox4=findViewById(R.id.choice4);
        if (checkBox1.isChecked() &&!checkBox2.isChecked()&& checkBox3.isChecked()&&!checkBox4.isChecked()) {
              points += 1;
        }

        displayToasts(points);
        points=0;
    }

    public void displayToasts(int points)
    {
        Context context=getApplicationContext();
        int time=Toast.LENGTH_SHORT;
        String toast_message=getString(R.string.toast1)+" "+points;
        if (toast != null) {
            toast.cancel();
        }
        toast = Toast.makeText(context, toast_message, time);
        toast.show();
    }
}


