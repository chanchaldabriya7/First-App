package com.metacube.chanchal.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class HomeScreenCategories extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen_categories);

        String []categories={
                "Contacts",
                "Electronic Products"
        };
        Integer []imgs= {
                R.mipmap.contacts,
                R.mipmap.electronics
        };
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
