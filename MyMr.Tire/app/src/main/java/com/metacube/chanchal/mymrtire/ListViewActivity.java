package com.metacube.chanchal.mymrtire;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity implements View.OnClickListener{

    FloatingActionButton plusButton;
    ListView listView;
    Button btn;
    TextView emptyText;
    List<String> list;
    CoordinatorLayout mainLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        list = new ArrayList<String>();
        list.add("A");
        list.add("A");
        list.add("R");
        list.add("A");
        list.add("A");
        list.add("X");
        list.add("A");
        list.add("A");
        list.add("A");
        list.add("X");
        list.add("A");
        list.add("A");
        list.add("A");
        list.add("X");
        list.add("A");


        mainLayout = (CoordinatorLayout) findViewById(R.id.mainLayout);
        emptyText = (TextView) findViewById(R.id.empty_text);

        listView = (ListView) findViewById(R.id.listView);
        plusButton = (FloatingActionButton) findViewById(R.id.floatbtn);

        btn = (Button) findViewById(R.id.btn);

        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list.toArray(new String[list.size()])));
        listView.setEmptyView(findViewById(R.id.empty_text));

        btn.setOnClickListener(this);
        plusButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn) {
            list.clear();
            listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list.toArray(new String[list.size()])));
            if( emptyText.getVisibility() == View.VISIBLE ) {
                CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) plusButton.getLayoutParams();
                params.gravity = Gravity.CENTER_HORIZONTAL;
                params.topMargin = 100;
                params.bottomMargin = 100;
                plusButton.setLayoutParams(params);
                ScaleAnimation animation = new ScaleAnimation(1,2,1,2);
                animation.setDuration(2000);
                plusButton.setAnimation(animation);

            }
        }
        else if(v.getId() == R.id.floatbtn) {
            Toast.makeText(this,"FAB pressed",Toast.LENGTH_SHORT).show();
        }
    }
}
