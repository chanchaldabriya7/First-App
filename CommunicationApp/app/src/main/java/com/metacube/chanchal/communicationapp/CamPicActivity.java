package com.metacube.chanchal.communicationapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class CamPicActivity extends AppCompatActivity {

    static final int REQUEST_CAMERA = 77;
    ImageView camImage;
    Button btnSnap;
    Animation fadeIn;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cam_pic);

        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Cam Pic");
        // Enable the Up button
        actionBar.setDisplayHomeAsUpEnabled(true);

        camImage = (ImageView) findViewById(R.id.cam_img);
        btnSnap = (Button) findViewById(R.id.btn_snap);

        btnSnap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePicture.resolveActivity(getPackageManager()) != null)
                    startActivityForResult(takePicture, REQUEST_CAMERA);
            }
        });

        fadeIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
        fadeIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Toast.makeText(getApplicationContext(),"End is here",Toast.LENGTH_SHORT).show();
                camImage.setVisibility(View.VISIBLE);
                camImage.setAlpha(1.0f);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        camImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                camImage.startAnimation(fadeIn);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CAMERA && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            camImage.setImageBitmap(imageBitmap);
            camImage.setVisibility(View.VISIBLE);
        }
    }

}
