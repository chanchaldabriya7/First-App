package com.metacube.chanchal.loginapp;

import android.app.FragmentTransaction;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class ContactsActivity extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        final ContactListFragment contactListFragment = new ContactListFragment();

        fragmentTransaction.add(R.id.contact_space,contactListFragment);
        fragmentTransaction.commit();

        btn= (Button) findViewById(R.id.btn_transition);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final NewContactFragment newContactFragment = new NewContactFragment();
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.contact_space,newContactFragment);
                fragmentTransaction.commit();
            }
        });
    }
}
