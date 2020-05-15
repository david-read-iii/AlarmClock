package com.read.alarmclock.Activities;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextClock;

import androidx.appcompat.app.AppCompatActivity;

import com.read.alarmclock.R;

public class ScreenSaverActivity extends AppCompatActivity {

    private String TIME_PATTERN = "h:mm a";
    private String TIME_PATTERN_WITH_SECONDS = "h:mm:ss a";
    private String DATE_PATTERN = "E, MMM d, yyyy";

    @Override
    protected void onCreate(Bundle savedBundleState) {
        super.onCreate(savedBundleState);
        setContentView(R.layout.activity_clock);

        // Set the format of the time text clock.
        TextClock textClockTime = findViewById(R.id.clock_time);
        textClockTime.setFormat12Hour(TIME_PATTERN);

        // Set the format of the date text clock.
        TextClock textClockDate = findViewById(R.id.clock_date);
        textClockDate.setFormat12Hour(DATE_PATTERN);

        // Hide the action bar.
        getSupportActionBar().hide();

        // Put this activity in fullscreen.
        View view = findViewById(R.id.clock_layout);
        view.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        );
    }

    /**
     * When any touch event is detected, go back to the clock activity.
     */
    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        finish();
        return false;
    }

}
