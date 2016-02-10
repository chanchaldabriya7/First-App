package com.metacube.chanchal.loginapp;

import android.app.FragmentTransaction;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class ContactsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;


        fragmentManager=getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        ContactListFragment contactListFragment = new ContactListFragment();

        fragmentTransaction.add(R.id.contact_space,contactListFragment);
        fragmentTransaction.commit();
    }
}
