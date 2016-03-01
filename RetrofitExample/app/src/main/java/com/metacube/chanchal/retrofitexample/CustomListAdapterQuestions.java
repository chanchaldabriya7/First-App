package com.metacube.chanchal.retrofitexample;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Chanchal on 25-02-2016.
 */
public class CustomListAdapterQuestions extends ArrayAdapter {
    private final Activity context;
    private final String[] title;
    private final String[] desc;

    public CustomListAdapterQuestions(Activity context, String[] title, String[] desc) {
        super(context, R.layout.question_layout, title);

        this.context = context;
        this.title = title;
        this.desc = desc;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.question_layout, null, true);

        TextView question = (TextView)rowView.findViewById(R.id.ques_text);
        TextView link = (TextView)rowView.findViewById(R.id.link_text);

        question.setText( title[position] );
        link.setText(desc[position]);
        return rowView;
    };
}
