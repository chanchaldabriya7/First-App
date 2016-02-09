package com.metacube.chanchal.loginapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.support.v4.app.ActivityCompat.startActivity;

/**
 * Created by Chanchal on 08-02-2016.
 */
public class CustomGridView extends BaseAdapter {
    String [] result;
    Context context;
    Integer [] imageId;
    private static LayoutInflater inflater=null;
    public CustomGridView(Context mainActivity, String[] prgmNameList, Integer[] prgmImages) {
        // TODO Auto-generated constructor stub
        result=prgmNameList;
        context=mainActivity;
        imageId=prgmImages;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.length;
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

    public class Holder
    {
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

        holder.tv.setText(result[position]);
        holder.img.setImageResource(imageId[position]);

        /*rowView.setOnClickListener(new View.OnClickListener() {
            Intent intent,intent1;
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(context, "You Clicked " + result[position], Toast.LENGTH_LONG).show();
                switch (position) {
                    case 1:
                        intent=new Intent(context,MyList.class);
                        startActivity(HomeScreenCategories.this,);
                        break;
                    case 0:
                        intent1=new Intent(context,ContactsActivity.class);
                        break;
                }
            }
        });*/
        return rowView;
    }
}
