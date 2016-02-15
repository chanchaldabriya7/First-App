package com.metacube.chanchal.communicationapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ShowListIndex extends AppCompatActivity {

    Button btnShowIndex;
    TextView indexDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list_index);

        indexDetails = (TextView)findViewById(R.id.index_details);
        btnShowIndex = (Button) findViewById(R.id.btn_show_index);
        btnShowIndex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent received = getIntent();
                int index = received.getIntExtra("index", 0);
                String listItem[] = received.getStringArrayExtra("company names");

                String resultText = "You pressed "+listItem[index]+" which is at index "+index;
                indexDetails.setText(resultText);
                Toast.makeText(getApplicationContext(),resultText,Toast.LENGTH_LONG).show();
               // System.out.println("You pressed "+index);
            }
        });
    }
}
