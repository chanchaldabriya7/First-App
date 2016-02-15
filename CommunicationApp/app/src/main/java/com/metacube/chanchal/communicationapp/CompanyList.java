package com.metacube.chanchal.communicationapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CompanyList extends AppCompatActivity {

    ListView list;
    Bundle myBundle;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_list);

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
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,companies);
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
