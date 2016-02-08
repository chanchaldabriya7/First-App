package com.metacube.chanchal.loginapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
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
        CustomGridView mygrid=new CustomGridView(getApplicationContext(),categories,imgs);
        grid.setAdapter(mygrid);

    }
}
