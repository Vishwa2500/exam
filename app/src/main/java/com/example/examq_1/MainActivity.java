package com.example.examq_1;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FlingAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button left,right,down,upbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView =findViewById(R.id.imageView);


        SpringAnimation springAnimationY = new SpringAnimation(imageView, DynamicAnimation.TRANSLATION_Y,0f);
        springAnimationY.getSpring().setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY);
        springAnimationY.getSpring().setStiffness(SpringForce.STIFFNESS_LOW);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                springAnimationY.animateToFinalPosition(800f);
            }
        });

        DynamicAnimation.OnAnimationEndListener endListener = new DynamicAnimation.OnAnimationEndListener(){

            @Override
            public void onAnimationEnd(DynamicAnimation animation, boolean canceled, float value, float velocity) {
                springAnimationY.animateToFinalPosition(0f);
            }
        };
        springAnimationY.addEndListener(endListener);

        FlingAnimation flingAnimation = new FlingAnimation(imageView,DynamicAnimation.ROTATION_X);

        flingAnimation.setStartVelocity(2000f);
        flingAnimation.setFriction(1.5f);
        flingAnimation.setMinValue(0f);
        flingAnimation.setMaxValue(1000f);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flingAnimation.start();
            }
        });

        left = findViewById(R.id.left);
       left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.left_animation);
                imageView.startAnimation(animation);
            }
        });
        right = findViewById(R.id.right);
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.right_animation);
                imageView.startAnimation(animation);
            }
        });
        down = findViewById(R.id.down);
        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.down_animation);
                imageView.startAnimation(animation);
            }
        });
        upbtn = findViewById(R.id.upbtn);
        upbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.up_animation);
                imageView.startAnimation(animation);
            }
        });
    }
}