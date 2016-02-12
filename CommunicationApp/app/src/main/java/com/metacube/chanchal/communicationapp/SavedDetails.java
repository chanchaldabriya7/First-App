package com.metacube.chanchal.communicationapp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SavedDetails extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    TextView textViewResult;
    Button btnGetResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_details);

        btnGetResult = (Button)findViewById(R.id.btn_getresult);
        btnGetResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences = getSharedPreferences("MyPreferences", MODE_PRIVATE);
                String name = sharedPreferences.getString("name", "default name");
                String email = sharedPreferences.getString("email", "default email");
                Long phone = sharedPreferences.getLong("phone", 0);

                textViewResult = (TextView) findViewById(R.id.result_text);
                textViewResult.setText("Name- " + name + "\nEmail- " + email + "\nPhone No.- " + phone);
            }
        });
    }
}
