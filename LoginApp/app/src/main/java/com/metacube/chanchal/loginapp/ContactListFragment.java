package com.metacube.chanchal.loginapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
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
    TreeMap<String,Long> contacts;
    public ContactListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View contact_list_view=inflater.inflate(R.layout.fragment_contact_list,container,false);
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
        contacts = new TreeMap<String,Long>();
        for(int i=0;i<contacts_name.length;i++)
            contacts.put(contacts_name[i],Long.parseLong(contacts_no[i]));
        recyclerView = (RecyclerView)contact_list_view.findViewById(R.id.my_recycler_view);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MyRecyclerViewAdapter(contacts);
        recyclerView.setAdapter(adapter);

        Button add_new = (Button)contact_list_view.findViewById(R.id.add_new_btn);
        add_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NewContactFragment newContactFragment = new NewContactFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.contact_space,newContactFragment);
                fragmentTransaction.commit();
            }
        });

        return contact_list_view;
    }
    protected void addNewContact(String name,Long number) {
        contacts.put(name, number);
    }
}
