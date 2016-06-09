package com.example.qiyue.customanimation.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.qiyue.customanimation.R;
import com.example.qiyue.customanimation.animation.RatioXAnimation;

public class RatioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratio);
        Button b = (Button) findViewById(R.id.Button01);
        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                View img = findViewById(R.id.img_0);
                img.startAnimation(new RatioXAnimation());
            }
        });
    }
}
