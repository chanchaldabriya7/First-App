package com.metacube.chanchal.retrofitexample;

import android.os.Build;
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
    private MyCountDownTimer countDownTimer;
    private long timeElapsed;
    private boolean timerHasStarted = false;
    private Button startB;
    private TextView text;
    private TextView timeElapsedView;

    private final long startTime = 50000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_count_down_timer);

        toolbar = (Toolbar) findViewById(R.id.my_actiontoolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.activity_countdown_timer);
        actionBar.setDisplayHomeAsUpEnabled(true);


        startB = (Button) this.findViewById(R.id.button);
        startB.setOnClickListener(this);

        text = (TextView) this.findViewById(R.id.timer);
        timeElapsedView = (TextView) this.findViewById(R.id.timeElapsed);
        long interval = 1000;
        countDownTimer = new MyCountDownTimer(startTime, interval);
        String temp = getString(R.string.time) + (float)startTime/1000;
        text.setText( temp );
    }
    @Override
    public void onClick(View v)
    {
        if (!timerHasStarted)
        {
            countDownTimer.start();
            timerHasStarted = true;
            startB.setText(R.string.pause);
        }
        else
        {
            countDownTimer.cancel();
            timerHasStarted = false;
            startB.setText(R.string.reset);
        }
    }


    class MyCountDownTimer extends CountDownTimer {

        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            String temp1,temp2;
            temp1 = getString(R.string.time_remain) + (float)millisUntilFinished/1000;
            temp2 = getString(R.string.timeElapsed) + (float)timeElapsed/1000;
            text.setText( temp1 );
            timeElapsed = startTime - millisUntilFinished;
            timeElapsedView.setText( temp2 );
        }

        @Override
        public void onFinish() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                text.setTextColor( getResources().getColorStateList(R.color.colorAccent,getTheme()));
            }

            text.setText(R.string.time_up);

            String temp = R.string.timeElapsed + String.valueOf((float)startTime/1000);
            timeElapsedView.setText( temp );

            startB.setText(R.string.start_again);
        }
    }


}

