package com.metacube.chanchal.retrofitexample;

import android.os.CountDownTimer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityCountDownTimer extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbar;
    private static final String tag = "Main";
    private MyCountDownTimer countDownTimer;
    private long timeElapsed;
    private boolean timerHasStarted = false;
    private Button startB;
    private TextView text;
    private TextView timeElapsedView;

    private final long startTime = 50000;
    private final long interval = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_count_down_timer);

        toolbar = (Toolbar) findViewById(R.id.my_actiontoolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("CountDownTimer");
        actionBar.setDisplayHomeAsUpEnabled(true);


        startB = (Button) this.findViewById(R.id.button);
        startB.setOnClickListener(this);

        text = (TextView) this.findViewById(R.id.timer);
        timeElapsedView = (TextView) this.findViewById(R.id.timeElapsed);
        countDownTimer = new MyCountDownTimer(startTime, interval);
        text.setText(text.getText() + String.valueOf((float)startTime/1000));
    }
    @Override
    public void onClick(View v)
    {
        if (!timerHasStarted)
        {
            countDownTimer.start();
            timerHasStarted = true;
            startB.setText("Pause");
        }
        else
        {
            countDownTimer.cancel();
            timerHasStarted = false;
            startB.setText("RESET");
        }
    }


    class MyCountDownTimer extends CountDownTimer {

        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            text.setText("Time remain:" + (float)millisUntilFinished/1000);
            timeElapsed = startTime - millisUntilFinished;
            timeElapsedView.setText("Time Elapsed: " + String.valueOf((float)timeElapsed/1000));
        }

        @Override
        public void onFinish() {
            text.setTextColor(getResources().getColor(R.color.colorAccent));
            text.setText("Time's up!");
            timeElapsedView.setText("Time Elapsed: " + String.valueOf((float)startTime/1000));
            startB.setText("Start Again");
        }
    }


}

