package com.metacube.chanchal.loginapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class ContactsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        String []contacts={
                "Anil Kumble",
                "Kapil Dev",
                "Sachin Tendulkar",
                "MS Dhoni",
                "Sunil Gavaskar",
                "Harbhajan Singh",
                "Yuvraj Singh",
                "Suresh Raina",
                "Ajit Agarkar"
        };

       recyclerView=(RecyclerView)findViewById(R.id.my_recycler_view);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new MyRecyclerViewAdapter(contacts);
        recyclerView.setAdapter(adapter);
    }
}
