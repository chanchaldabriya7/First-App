package com.metacube.chanchal.communicationapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ShowListIndex extends AppCompatActivity {

    Button btnShowIndex;
    TextView indexDetails;
    Toolbar myToolbar;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list_index);

        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Show List Index");
        // Enable the Up button
        actionBar.setDisplayHomeAsUpEnabled(true);

        indexDetails = (TextView)findViewById(R.id.index_details);
        btnShowIndex = (Button) findViewById(R.id.btn_show_index);
        btnShowIndex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog = new ProgressDialog(v.getContext());
                progressDialog.setMessage("Fetching Data...");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setIndeterminate(false);
                progressDialog.setProgress(0);
                progressDialog.show();

                final int totalProgressTime = 100;
                final Thread t = new Thread() {
                    @Override
                    public void run() {
                        int jumpTime = 0;

                        while(jumpTime < totalProgressTime) {
                            try {
                                sleep(600);
                                jumpTime += 1;
                                progressDialog.setProgress(jumpTime);
                            }
                            catch (InterruptedException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                        progressDialog.dismiss();
                    }
                };
                t.start();
                Intent received = getIntent();
                int index = received.getIntExtra("index", 0);
                String listItem[] = received.getStringArrayExtra("company names");

                String resultText = "You pressed "+listItem[index]+" which is at index "+index;
                System.out.println("Inside the spcl loop");
                indexDetails.setText(resultText);
                Toast.makeText(getApplicationContext(),resultText,Toast.LENGTH_LONG).show();
            }
        });
    }
}
