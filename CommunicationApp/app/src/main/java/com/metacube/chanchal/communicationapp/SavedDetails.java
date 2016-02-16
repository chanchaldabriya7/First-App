package com.metacube.chanchal.communicationapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SavedDetails extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    TextView textViewResult;
    Button btnGetResult,btnList,btnCall,btnMail;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_details);

        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Saved Details");
        // Enable the Up button
        actionBar.setDisplayHomeAsUpEnabled(true);

        btnGetResult = (Button)findViewById(R.id.btn_getresult);
        btnList = (Button) findViewById(R.id.btn_list);
        btnCall = (Button)findViewById(R.id.btn_call);
        btnMail = (Button)findViewById(R.id.btn_mail);
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

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentList = new Intent(getApplicationContext(), CompanyList.class);
                startActivity(intentList);
            }
        });

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:9829077777"));
                startActivity(callIntent);
            }
        });
        btnMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences = getSharedPreferences("MyPreferences", MODE_PRIVATE);
                String email = sharedPreferences.getString("email","default email");
                String name = sharedPreferences.getString("name", "default name");
                Long phone = sharedPreferences.getLong("phone", 0);

                Intent intent = new Intent(Intent.ACTION_SENDTO,Uri.fromParts("mailto", email, null));
               // intent.setData(Uri.parse("mailto:"));
               // intent.setType("text/plain");
                //intent.putExtra(Intent.EXTRA_EMAIL, new String[] {} );
                intent.putExtra(Intent.EXTRA_CC,new String[] {"chanchaldabriya@outlook.com"} );
                intent.putExtra(Intent.EXTRA_SUBJECT, name);
                intent.putExtra(Intent.EXTRA_TEXT, "Contact Details\nName: "+name+"\nContact No.: "+phone);

                startActivity(Intent.createChooser(intent, "Send Email with..."));

            }
        });
    }
}
