package com.metacube.chanchal.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyExpandableList extends AppCompatActivity {

    private ExpandableListView expandableListView;

    private List<String> parentHeaderInformation;
    private HashMap<String,String> child;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_expandable_list);

        Intent prev_intent = getIntent();
        int id = prev_intent.getIntExtra("id", 0);
        parentHeaderInformation = new ArrayList<String>();
        child=new HashMap<String,String>();
        switch (id) {
            case 0:
                parentHeaderInformation.add("Apple Iphone");
                parentHeaderInformation.add("Apple Ipad");
                child.put(parentHeaderInformation.get(0), "Apple Iphone 6S");
                child.put(parentHeaderInformation.get(1),"Apple Ipad Air");
                break;
            case 1:
                parentHeaderInformation.add("Samsung Galaxy S6");
                parentHeaderInformation.add("Samsung Note");
                child.put(parentHeaderInformation.get(0), "Samsung Galaxy Edge");
                child.put(parentHeaderInformation.get(1), "Samsung Galaxy Note 4");
                break;
            case 2:
                parentHeaderInformation.add("LG G3");
                parentHeaderInformation.add("LG G4");
                child.put(parentHeaderInformation.get(0), "LG G3 cube");
                child.put(parentHeaderInformation.get(1), "LG G4 style icon");
                break;
            default:
                parentHeaderInformation.add("Apple Iphone");
                parentHeaderInformation.add("Apple Ipad");
                child.put(parentHeaderInformation.get(0), "Apple Iphone 6S");
                child.put(parentHeaderInformation.get(1), "Apple Ipad Air");
        }
        expandableListView = (ExpandableListView)findViewById(R.id.expandableListView);

        CustomExpandableListAdapter expandableListViewAdapter = new CustomExpandableListAdapter(getApplicationContext(), parentHeaderInformation, child,id);

        expandableListView.setAdapter(expandableListViewAdapter);
    }
}
