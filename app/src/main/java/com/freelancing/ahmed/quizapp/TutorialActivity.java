package com.freelancing.ahmed.quizapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import jp.wasabeef.glide.transformations.BlurTransformation;

public class TutorialActivity extends AppCompatActivity {
    ImageView tutorialImage;
    TextView tv1;
    Button startbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
        setTitle("information");
        tutorialImage = (ImageView) findViewById(R.id.tutorialimage);
        tutorialImage.setImageBitmap(ImageNicer.decodeSampledBitmapFromResource(getResources(), R.drawable.quizspash, 300, 300));
        tv1 = (TextView) findViewById(R.id.harrydescTitle);
        Typeface myTypeface = Typeface.createFromAsset(this.getAssets(), "harry.ttf");
        tv1.setTypeface(myTypeface);
        tv1.setTextSize(45);
        startbtn= (Button) findViewById(R.id.startbtn);
        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TutorialActivity.this,QuizActivity.class);
                startActivity(i);

            }
        });
    }


}
