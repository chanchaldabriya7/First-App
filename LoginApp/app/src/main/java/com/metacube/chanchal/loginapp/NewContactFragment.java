package com.metacube.chanchal.loginapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.metacube.chanchal.loginapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewContactFragment extends Fragment {


    public NewContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_new_contact,container,false);
        return v;
    }

}
