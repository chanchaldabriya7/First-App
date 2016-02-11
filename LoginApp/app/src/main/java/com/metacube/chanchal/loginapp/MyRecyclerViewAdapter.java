package com.metacube.chanchal.loginapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.SortedSet;
import java.util.TreeMap;

/**
 * Created by Chanchal on 08-02-2016.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {
    private TreeMap<String,Long> mDataset;
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView no;

        public ViewHolder(View v) {
            super(v);
            name=(TextView)v.findViewById(R.id.contact_name);
            no=(TextView)v.findViewById(R.id.contact_no);
        }
    }

    public MyRecyclerViewAdapter(TreeMap<String,Long> myDataset) {
        mDataset = myDataset;
    }
    @Override
    public MyRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_contact_view, parent, false);
        // set the view's size, margins, paddings and layout parameters
       // ...
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element


        SortedSet<String> keys=(SortedSet<String>)mDataset.keySet();
        Object names[]=keys.toArray();

        holder.name.setText(names[position].toString());
        holder.no.setText(mDataset.get(names[position]).toString());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}