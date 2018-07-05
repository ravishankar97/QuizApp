package com.example.ravishankar.quizapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    public static int splash_time=4000;
    Button button;
    Animation button_animation,image_animation;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.start);
        imageView=findViewById(R.id.scholar_image);
        button_animation= AnimationUtils.loadAnimation(this,R.anim.button_animation);
        image_animation=AnimationUtils.loadAnimation(this,R.anim.scholar_animation);
        button.setAnimation(button_animation);
        imageView.setAnimation(image_animation);
    }

    public void start(View view) {
        Intent intent = new Intent(MainActivity.this,HomeActivity.class);
        startActivity(intent);
    }
}
