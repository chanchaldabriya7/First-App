package com.metacube.chanchal.loginapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MyList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);

        String fruits[]={"Apple","Banana","Cherry"};
        Integer imgid[]={
                R.mipmap.apple,
                R.mipmap.banana,
                R.mipmap.cherry
        };
        ListView list = (ListView) findViewById(R.id.listView);
        CustomListAdapter ad = new CustomListAdapter(this,fruits,imgid);
        list.setAdapter(ad);
    }
}
