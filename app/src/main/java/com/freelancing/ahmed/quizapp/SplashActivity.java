package com.freelancing.ahmed.quizapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {
    private TextView tvSplash;
    private ImageView imgSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        imgSplash = (ImageView) findViewById(R.id.imageSplash);
        tvSplash = (TextView) findViewById(R.id.txtview1);
        imgSplash.setImageBitmap(ImageNicer.decodeSampledBitmapFromResource(getResources(), R.drawable.quizspash, 300, 300));
        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.mytransition);
        tvSplash.startAnimation(myanim);
        imgSplash.startAnimation(myanim);
        Typeface myTypeface = Typeface.createFromAsset(this.getAssets(), "harry.ttf");
        tvSplash.setTypeface(myTypeface);
        tvSplash.setTextSize(50);
        final Intent i = new Intent(this, TutorialActivity.class);
        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(i);
                    finish();
                }
            }
        };
        timer.start();
    }
}
