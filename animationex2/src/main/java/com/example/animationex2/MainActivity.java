package com.example.animationex2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {
    ImageView img1;
    Animation ani1, ani2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img1=findViewById(R.id.img1);
        Glide.with(this).load(R.drawable.panthera).into(img1);
        ani1=AnimationUtils.loadAnimation(this, R.anim.show);
        img1.startAnimation(ani1);
        ani1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Toast.makeText(getApplicationContext(),"강이지가 지나갑니다.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //이미지가 나타난 후 실행
                ani2=AnimationUtils.loadAnimation(MainActivity.this, R.anim.move);
                img1.startAnimation(ani2);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}