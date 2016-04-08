package com.metacube.chanchal.mymrtire;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class ElevationBorderScrollActivity extends AppCompatActivity implements View.OnClickListener{

    ScrollView scrollView;
    LinearLayout myLinearLayout;
    float bottomLayoutElevation;
    Button clearOne, clearTwo, clearThree;
    LinearLayout bottomLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elevation_border_scroll);
        bottomLayout = (LinearLayout) findViewById(R.id.bottomLayout);
        bottomLayoutElevation = bottomLayout.getElevation();
        //setContentView(R.layout.elevation_example);
       /* scrollView = (ScrollView) findViewById(R.id.myscrollView);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.scrollContent);
        RelativeLayout myRelativeLayout = (RelativeLayout) scrollView.getChildAt(0);
        System.out.println("Scroll view --------"+scrollView.getHeight());
        System.out.println("Scroll content --------" + relativeLayout.getHeight());
        System.out.println("Scroll content my --------" + myRelativeLayout.getHeight());*/


        clearOne = (Button) findViewById(R.id.btnOne);
        clearTwo = (Button) findViewById(R.id.btnTwo);
        clearThree = (Button) findViewById(R.id.btnThree);

        clearOne.setOnClickListener(this);
        clearTwo.setOnClickListener(this);
        clearThree.setOnClickListener(this);

        scrollView = (ScrollView) findViewById(R.id.myscrollView);

        check();


    }

    public void check() {
        scrollView.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        myLinearLayout = (LinearLayout) scrollView.getChildAt(0);

                        System.out.println("1--" + scrollView.getHeight() + "-----2.----" + myLinearLayout.getHeight() + "-----extra1---" + myLinearLayout.getPaddingTop() + "-----extra1---" + myLinearLayout.getPaddingBottom());

                        if(scrollView.getHeight() >= myLinearLayout.getHeight()) {
                            bottomLayout.setElevation(0);
                        }
                        else {
                            bottomLayout.setElevation(bottomLayoutElevation);
                            System.out.println(bottomLayoutElevation);
                        }


                        scrollView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                }
        );
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnOne:
                TextView one = (TextView) findViewById(R.id.one);
                one.setText("1");
                check();
                break;
            case R.id.btnTwo:
                TextView two = (TextView) findViewById(R.id.two);
                two.setText("2");
                check();
                break;
            case R.id.btnThree:
                TextView three = (TextView) findViewById(R.id.three);
                three.setText("3");
                check();
                break;
        }
    }

  /*  @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        System.out.println("scroll view in onPOst-----" + scrollView.getHeight());
        System.out.println("my view in onPOst-----" + myLinearLayout.getHeight());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("scroll view in Destroy-----   " + scrollView.getHeight());
        System.out.println("my view in Destroy-----   "+(myLinearLayout.getHeight()+myLinearLayout.getPaddingTop()+myLinearLayout.getPaddingBottom()));
    }*/
}
