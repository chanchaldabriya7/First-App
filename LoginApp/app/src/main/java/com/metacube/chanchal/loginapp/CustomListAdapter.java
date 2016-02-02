package com.metacube.chanchal.loginapp;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] itemname;
    private final Integer[] imgid;

    public CustomListAdapter(Activity context, String[] itemname, Integer[] imgid) {
        super(context, R.layout.sample_my_fruit_list_view, itemname);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.itemname=itemname;
        this.imgid=imgid;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.sample_my_fruit_list_view, null,true);

        ImageView logo = (ImageView) rowView.findViewById(R.id.imageView);
        TextView text = (TextView) rowView.findViewById(R.id.textView);


        logo.setImageResource(imgid[position]);
        text.setText(itemname[position]);
        return rowView;
    };
}
