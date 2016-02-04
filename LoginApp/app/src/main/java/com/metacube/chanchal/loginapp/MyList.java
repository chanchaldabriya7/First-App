package com.metacube.chanchal.loginapp;

import android.content.Intent;
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

        String brands[]={"Apple","Samsung","LG"};
        Integer imgid[]={
                R.mipmap.apple,
                R.mipmap.samsung,
                R.mipmap.lg
        };
        String descriptions[]={
                "Apple Inc. is an American multinational technology company headquartered in Cupertino, California, that designs, develops, and sells consumer electronics, computer software, and online services.",
                "Samsung was founded by Lee Byung-chul in 1938 as a trading company. Over the next three decades, the group diversified into areas including food processing, textiles, insurance, securities and retail.",
                "LG Corporation  formerly Lucky Goldstar (Korean: Leokki Geumseong  ) is a South Korean multinational conglomerate corporation."
        };
        String time_posts[]={
                "Yesterday",
                "4.15 PM",
                "SEP 22",
                "OCT 31"
        };
        ListView list = (ListView) findViewById(R.id.listView);
        CustomListAdapter ad = new CustomListAdapter(this,brands,imgid,descriptions,time_posts);
        list.setAdapter(ad);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(MyList.this,"Item "+position+" pressed.",Toast.LENGTH_SHORT).show();
                Intent expandable = new Intent(getApplicationContext(),MyExpandableList.class);
                expandable.putExtra("id",position);
                startActivity(expandable);
            }
        });
    }
}
