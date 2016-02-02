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
    private final String[] desc;
    private final String[] tm;

    public CustomListAdapter(Activity context, String[] itemname, Integer[] imgid,String desc[],String tm[]) {
        super(context, R.layout.sample_my_fruit_list_view, itemname);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.itemname=itemname;
        this.imgid=imgid;
        this.desc=desc;
        this.tm=tm;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.sample_my_fruit_list_view, null, true);

        ImageView logo = (ImageView) rowView.findViewById(R.id.logo);
        TextView text = (TextView) rowView.findViewById(R.id.title_text);
        TextView descript = (TextView)rowView.findViewById(R.id.description_text);
        TextView timing = (TextView)rowView.findViewById(R.id.time_text);

        logo.setImageResource(imgid[position]);
        text.setText(itemname[position]);
        if(desc[position].length()>100)
            descript.setText(desc[position].substring(0,100)+"...");
        else
            descript.setText(desc[position]);
        timing.setText(tm[position]);
        return rowView;
    };
}
