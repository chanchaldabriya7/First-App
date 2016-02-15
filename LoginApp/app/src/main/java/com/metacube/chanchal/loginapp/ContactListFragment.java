package com.metacube.chanchal.loginapp;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import java.util.TreeMap;

public class ContactListFragment extends Fragment implements AdapterView.OnClickListener{

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    Activity activity;
    AccessMap interfaceVariable;
    TreeMap<String,Long> contacts;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity=activity;
        interfaceVariable = (AccessMap)activity;
    }

    /*@Override
    public void onAttach(Context context) {
        super.onAttach(context);

        this.activity = getActivity();
        interfaceVariable = (AccessMap)activity;
    }*/

    public ContactListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View contact_list_view=inflater.inflate(R.layout.fragment_contact_list,container,false);

        contacts = interfaceVariable.getMap();

        recyclerView = (RecyclerView)contact_list_view.findViewById(R.id.my_recycler_view);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MyRecyclerViewAdapter(contacts);
        recyclerView.setAdapter(adapter);

        Button add_new = (Button)contact_list_view.findViewById(R.id.add_new_btn);
        add_new.setOnClickListener(this);

        return contact_list_view;
    }

    @Override
    public void onClick(View v) {
        interfaceVariable.setMap(contacts,this);
    }

    public interface AccessMap {
        TreeMap<String,Long> getMap();
        void setMap(TreeMap<String,Long> map,Object o);
    }

}
