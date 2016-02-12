package com.metacube.chanchal.loginapp;

import android.app.FragmentTransaction;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.TreeMap;

public class ContactsActivity extends AppCompatActivity implements ContactListFragment.AccessMap {

    TreeMap<String,Long> contacts;
    ContactListFragment contactListFragment;
    NewContactFragment newContactFragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        initializeContactList();

        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        contactListFragment = new ContactListFragment();

        fragmentTransaction.add(R.id.contact_space,contactListFragment);
        fragmentTransaction.commit();
    }

    public  void initializeContactList() {
        String []contacts_name={
                "Anil Kumble",
                "Kapil Dev",
                "Sachin Tendulkar",
                "MS Dhoni",
                "Sunil Gavaskar",
                "Harbhajan Singh",
                "Yuvraj Singh",
                "Suresh Raina",
                "Ajit Agarkar"
        };

        String []contacts_no={
                "9829012345",
                "9829012458",
                "9855954125",
                "9855954185",
                "9855954475",
                "9855954365",
                "9855268795",
                "9268954125",
                "9823954125"
        };
        contacts = new TreeMap<String,Long>();
        for(int i=0;i<contacts_name.length;i++)
            contacts.put(contacts_name[i],Long.parseLong(contacts_no[i]));
    }
    @Override
    public TreeMap<String, Long> getMap() {
        return this.contacts;
    }

    @Override
    public void setMap(TreeMap<String, Long> map,Object o) {
        this.contacts = map;
        newContactFragment = new NewContactFragment();
        contactListFragment = new ContactListFragment();
        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        if(o instanceof ContactListFragment)
            fragmentTransaction.replace(R.id.contact_space,newContactFragment).commit();
        else
            fragmentTransaction.replace(R.id.contact_space,contactListFragment).commit();
    }

}
