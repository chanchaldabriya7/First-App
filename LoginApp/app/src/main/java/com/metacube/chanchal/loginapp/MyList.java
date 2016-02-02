package com.metacube.chanchal.loginapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MyList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);

        String fruits[]={"Apple","Banana","Cherry","Mango"};
        Integer imgid[]={
                R.mipmap.apple,
                R.mipmap.banana,
                R.mipmap.cherry,
                R.mipmap.mango
        };
        String descriptions[]={
                "The apple tree (Malus domestica) is a deciduous tree in the rose family best known for its sweet, pomaceous fruit, the apple.",
                "The banana is an edible fruit, botanically a berry, produced by several kinds of large herbaceous flowering plants in the genus Musa.",
                "A cherry is the fruit of many plants of the genus Prunus, and is a fleshy drupe (stone fruit).",
                "The mango is a juicy stone fruit (drupe) belonging to the genus Mangifera, consisting of numerous tropical fruiting trees, cultivated mostly for edible fruit."
        };
        String time_posts[]={
                "Yesterday",
                "4.15 PM",
                "SEP 22",
                "OCT 31"
        };
        ListView list = (ListView) findViewById(R.id.listView);
        CustomListAdapter ad = new CustomListAdapter(this,fruits,imgid,descriptions,time_posts);
        list.setAdapter(ad);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MyList.this,"Item "+position+" pressed.",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
