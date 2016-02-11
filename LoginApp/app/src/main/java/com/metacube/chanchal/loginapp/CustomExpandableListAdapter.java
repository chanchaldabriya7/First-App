package com.metacube.chanchal.loginapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class CustomExpandableListAdapter extends BaseExpandableListAdapter {
    private Context context;

    private List<String> parentDataSource;

    private HashMap<String, String> childDataSource;
    private int menu_id;

    public CustomExpandableListAdapter(Context context, List<String> childParent, HashMap<String, String> child,int id) {

        this.context = context;

        this.parentDataSource = childParent;

        this.childDataSource = child;

        this.menu_id = id;
    }


    @Override
    public int getGroupCount() {
        return this.parentDataSource.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return parentDataSource.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childDataSource.get(parentDataSource.get(groupPosition));
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        View view = convertView;

        if(view == null){

            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(R.layout.expandable_parent, parent, false);

        }

        String parentHeader = (String)getGroup(groupPosition);

        TextView parentItem = (TextView)view.findViewById(R.id.parent_text);

        parentItem.setText(parentHeader);

        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {

            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(R.layout.expandable_child, parent, false);
        }

        Integer images_id[]={
        R.mipmap.iphone,
        R.mipmap.ipad,
        R.mipmap.s6,
        R.mipmap.note,
        R.mipmap.g3,
        R.mipmap.g4
    };

        TextView content_main=(TextView)view.findViewById(R.id.textView1);
        TextView content_sub=(TextView)view.findViewById(R.id.textView2);
        ImageView content_img=(ImageView)view.findViewById(R.id.imageView);
        String main_text = null,sub_text = null;
        System.out.println(groupPosition+"\t"+childPosition);
        switch (menu_id) {
            case 0: //for apple
                switch (groupPosition) {
                    case 0:
                        main_text = "60,000/-";
                        sub_text = "1,000,000";
                        content_img.setImageResource(images_id[0]);
                        break;
                    case 1:
                        main_text = "30,000/-";
                        sub_text = "50,000";
                        content_img.setImageResource(images_id[1]);
                        break;
                }
                break;
            case 1: //for samsung
                switch (groupPosition) {
                    case 0:
                        main_text = "40,000/-";
                        sub_text = "5,000,000";
                        content_img.setImageResource(images_id[2]);
                        break;
                    case 1:
                        main_text = "55,000/-";
                        sub_text = "10,000,000";
                        content_img.setImageResource(images_id[3]);
                        break;
                }
                break;
            case 2://for LG
                switch (groupPosition) {
                    case 0:
                        main_text = "25,000/-";
                        sub_text = "90,000";
                        content_img.setImageResource(images_id[4]);
                        break;
                    case 1:
                        main_text = "35,000/-";
                        sub_text = "1,500,000";
                        content_img.setImageResource(images_id[5]);
                        break;
                }
                break;
        }

        content_main.setText(main_text);
        content_sub.setText(sub_text+" units sold.");
        return view;
    }
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
       return true;
    }
}
