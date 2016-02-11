package com.metacube.chanchal.loginapp;


import android.app.Fragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.metacube.chanchal.loginapp.R;

import java.util.TreeMap;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewContactFragment extends Fragment {

    EditText contactName;
    EditText contactNo;
    Button addContact;
    ContactListFragment original_fragment;
    public  NewContactFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View new_contact_view=inflater.inflate(R.layout.fragment_new_contact, container, false);

        contactName = (EditText)new_contact_view.findViewById(R.id.editText_addname);
        contactNo = (EditText)new_contact_view.findViewById(R.id.editText_addno);

        /*addContact=(Button)new_contact_view.findViewById(R.id.add_new);
        addContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = contactName.getText().toString();
                Long number = Long.parseLong(contactNo.getText().toString());
                //addNewContact(name, number);
            }
        });*/

        return new_contact_view;
    }
    /*private void addNewContact(String name,Long num) {
        *//*ContactListFragment temp_fragment = new ContactListFragment();
        temp_fragment.addNewContact(name,num);*//*
    }*/
}
