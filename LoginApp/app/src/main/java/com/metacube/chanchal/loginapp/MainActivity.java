package com.metacube.chanchal.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText uname = (EditText)findViewById(R.id.uname);
        final EditText pass = (EditText)findViewById(R.id.pass);
        Button btn = (Button)findViewById(R.id.button);

        btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = uname.getText().toString();
                final String password = pass.getText().toString();

               if(loginCheck(username,password))
                {
                  Toast.makeText(getApplicationContext(),"Hello  "+username,Toast.LENGTH_SHORT).show();
                   Intent i = new Intent(getApplicationContext(),MyList.class);
                    uname.setText("");  //reset the uname after login successful
                    pass.setText("");   //reset the pass
                    startActivity(i);
                }
                else
                    Toast.makeText(getApplicationContext(),"Invalid Login",Toast.LENGTH_LONG).show();
            }
        });
    }
    protected boolean loginCheck(String uname,String pass){
        if(uname.equals("chanchal") && pass.equals("dabriya"))
            return true;
        return false;
    }

}
