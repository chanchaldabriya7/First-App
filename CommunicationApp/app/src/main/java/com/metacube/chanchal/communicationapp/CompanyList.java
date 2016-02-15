package com.metacube.chanchal.communicationapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class CompanyList extends AppCompatActivity {

    ListView list;
    Toolbar toolbar;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_list);

        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Company List");
        // Enable the Up button
        actionBar.setDisplayHomeAsUpEnabled(true);

        final String companies[] = {
                "Google",
                "Microsoft",
                "Apple",
                "Samsung",
                "Motorola",
                "LG",
                "XOLO",
                "Sony"
        };
        list = (ListView)findViewById(R.id.companyList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,companies){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView text = (TextView) view.findViewById(android.R.id.text1);
                text.setTextColor(Color.BLACK);
                return view;
            }
        };
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intentShowIndex = new Intent(getApplicationContext(),ShowListIndex.class);
                intentShowIndex.putExtra("index",position);
                intentShowIndex.putExtra("company names",companies);
                startActivity(intentShowIndex);
            }
        });
    }
}
