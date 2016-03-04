package com.metacube.chanchal.loginapp;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;


public class HomeScreenCategories extends AppCompatActivity {

    DrawerLayout mDrawerLayout;
    ListView drawerList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen_categories);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.menu_drawer);
        drawerList = (ListView) findViewById(R.id.drawer_list);

        String []categories={
                "Contacts",
                "Electronic Products"
        };
        Integer []imgs= {
                R.mipmap.contacts,
                R.mipmap.electronics
        };

        drawerList.setBackgroundResource(R.mipmap.johny);
        drawerList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, categories) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView textView = (TextView) super.getView(position, convertView, parent);
                textView.setTextColor(getColor(R.color.white));
                return textView;
            }
        });
        drawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                drawerList.setItemChecked(position,false);
                mDrawerLayout.closeDrawer(drawerList);
            }
        });


        GridView grid = (GridView)findViewById(R.id.gridView);
        CustomGridView mygrid = new CustomGridView(getApplicationContext(),categories,imgs);        //Adapter for Grid view
        grid.setAdapter(mygrid);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:     //For Contacts
                        Intent intent_contact=new Intent(getApplicationContext(),ContactsActivity.class);
                        startActivity(intent_contact);
                        break;
                    case 1:     ////For Electronics
                       Intent intent_electronics=new Intent(getApplicationContext(),MyList.class);
                        startActivity(intent_electronics);
                        break;
                }
            }
        });
    }

}
