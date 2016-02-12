package com.metacube.chanchal.loginapp;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;

import com.metacube.chanchal.loginapp.R;

import java.lang.ref.SoftReference;
import java.util.TreeMap;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewContactFragment extends Fragment implements AdapterView.OnClickListener{

    EditText contactName;
    EditText contactNo;
    Button addContact;
    Activity activity;
    ContactListFragment.AccessMap interfaceVariable;
    ContactListFragment original_fragment;
    public  NewContactFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity=activity;
        interfaceVariable = (ContactListFragment.AccessMap)activity;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View new_contact_view=inflater.inflate(R.layout.fragment_new_contact, container, false);

        contactName = (EditText)new_contact_view.findViewById(R.id.editText_addname);
        contactNo = (EditText)new_contact_view.findViewById(R.id.editText_addno);

        addContact=(Button)new_contact_view.findViewById(R.id.add_new);
        addContact.setOnClickListener(this);

        return new_contact_view;
    }

    @Override
    public void onClick(View v) {
        String name = contactName.getText().toString();
        Long number = Long.parseLong(contactNo.getText().toString());
        TreeMap<String,Long> contacts = interfaceVariable.getMap();     //get map from activity
        contacts.put(name,number);                                      //adding new contact to local copy of map
        interfaceVariable.setMap(contacts,this);                             //setting new map as map in activity
    }

}
