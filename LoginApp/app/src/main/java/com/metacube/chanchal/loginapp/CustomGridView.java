package com.metacube.chanchal.loginapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by Chanchal on 08-02-2016.
 */
public class CustomGridView extends BaseAdapter {
    String [] names;
    Context context;
    Integer [] imageId;
    private static LayoutInflater inflater=null;
    public CustomGridView(Context mainActivity, String[] prgmNameList, Integer[] prgmImages) {
        // TODO Auto-generated constructor stub
        context=mainActivity;
        names=prgmNameList;
        imageId=prgmImages;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return names.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder {
        TextView tv;
        ImageView img;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        final View rowView;

        rowView = inflater.inflate(R.layout.single_grid_element, null);
        holder.tv=(TextView) rowView.findViewById(R.id.gridText);
        holder.img=(ImageView) rowView.findViewById(R.id.gridImage);

        holder.tv.setText(names[position]);
        holder.img.setImageResource(imageId[position]);

        return rowView;
    }
}
