package com.metacube.chanchal.communicationapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ContactList extends AppCompatActivity {

    ListView list;
    Bundle myBundle;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);

        String companies[] = {
                "Google",
                "Microsoft",
                "Apple",
                "IBM",
                "Yahoo"
        };
        list = (ListView)findViewById(R.id.companyList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,companies);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                myBundle = new Bundle();

                //
            }
        });
    }
}
