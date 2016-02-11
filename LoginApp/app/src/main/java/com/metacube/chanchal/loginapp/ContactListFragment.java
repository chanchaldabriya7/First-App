package com.metacube.chanchal.loginapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import java.util.TreeMap;

public class ContactListFragment extends Fragment {


    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    public ContactListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_contact_list,container,false);
        String []contacts_name={
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

        String []contacts_no={
                "9829012345",
                "9829012458",
                "9855954125",
                "9855954185",
                "9855954475",
                "9855954365",
                "9855268795",
                "9268954125",
                "9823954125"
        };
        /*for(int i=0;i<contacts_name.length;i++)
            System.out.println(contacts_name[i]+"\t"+Long.parseLong(contacts_no[i]));*/
        TreeMap<String,Long> contacts = new TreeMap<String,Long>();
        for(int i=0;i<contacts_name.length;i++)
            contacts.put(contacts_name[i],Long.parseLong(contacts_no[i]));
        recyclerView=(RecyclerView)v.findViewById(R.id.my_recycler_view);

        layoutManager=new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(layoutManager);
        adapter=new MyRecyclerViewAdapter(contacts);
        recyclerView.setAdapter(adapter);

        /*Button add_new = (Button)container.findViewById(R.id.add_new_btn);
        add_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/

        return v;

    }

}
