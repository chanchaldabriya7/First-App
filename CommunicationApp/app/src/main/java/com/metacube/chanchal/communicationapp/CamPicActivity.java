package com.metacube.chanchal.communicationapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CamPicActivity extends AppCompatActivity {

    static final int REQUEST_CAMERA = 77;
    ImageView camImage;
    Button btnSnap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cam_pic);

        camImage = (ImageView) findViewById(R.id.cam_img);
        btnSnap = (Button) findViewById(R.id.btn_snap);

        btnSnap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if(takePicture.resolveActivity(getPackageManager())!=null)
                    startActivityForResult(takePicture,REQUEST_CAMERA);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CAMERA && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            camImage.setImageBitmap(imageBitmap);
        }
    }
}
