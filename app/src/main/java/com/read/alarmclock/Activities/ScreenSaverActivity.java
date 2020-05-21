package com.read.alarmclock.Activities;

import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextClock;

import androidx.appcompat.app.AppCompatActivity;

import com.read.alarmclock.R;

public class ScreenSaverActivity extends AppCompatActivity {

    private String TIME_PATTERN = "h:mm a";
    private String TIME_PATTERN_WITH_SECONDS = "h:mm:ss a";
    private String DATE_PATTERN = "E, MMM d, yyyy";
    private TextClock textClockTime;
    private Handler handler;
    private Runnable runnable;

    /**
     * When this activity is created, inflate the layout in {@link R.layout#activity_clock}. Also,
     * fullscreen this activity and set the format of each text clock.
     */
    @Override
    protected void onCreate(Bundle savedBundleState) {
        super.onCreate(savedBundleState);
        setContentView(R.layout.activity_clock);

        // Hide the toolbar.
        getSupportActionBar().hide();

        // Hide the system ui.
        View view = findViewById(R.id.outer_clock_layout);
        view.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LOW_PROFILE
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        );

        // Set the format of the time text clock.
        textClockTime = findViewById(R.id.text_clock_time);
        textClockTime.setFormat12Hour(TIME_PATTERN);

        // Set the format of the date text clock.
        TextClock textClockDate = findViewById(R.id.text_clock_date);
        textClockDate.setFormat12Hour(DATE_PATTERN);
    }

    /**
     * When this activity is resumed, create and execute a runnable to move a layout containing each
     * text clock around the screen.
     */
    @Override
    protected void onResume() {
        super.onResume();

        // Bring the layouts to Java.
        final FrameLayout outerClockLayout = findViewById(R.id.outer_clock_layout);
        final LinearLayout innerClockLayout = findViewById(R.id.inner_clock_layout);

        // Initialize the position and speed of the innerClockLayout.
        final int[] positionX = {0};
        final int[] positionY = {0};
        final int[] speedX = {4};
        final int[] speedY = {4};

        // Create FrameLayout.LayoutParams object to manage the position and size of the innerClockLayout.
        final FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);

        // Set the initial position of the innerClockLayout.
        params.leftMargin = positionX[0];
        params.topMargin = positionY[0];

        // Remove the old innerClockLayout and add the new innerClockLayout to the outerClockLayout.
        outerClockLayout.removeAllViews();
        outerClockLayout.addView(innerClockLayout, params);

        // Create a Handler to execute a runnable.
        handler = new Handler();

        // Define a runnable to move the innerClockLayout across the outerClockLayout.
        runnable = new Runnable() {
            @Override
            public void run() {

                // Increment the position of the innerClockLayout.
                positionX[0] = positionX[0] + speedX[0];
                positionY[0] = positionY[0] + speedY[0];

                // If innerClockLayout has crossed the screen boundary, reverse its speed.
                if (positionX[0] <= 2 || positionX[0] >= outerClockLayout.getMeasuredWidth() - innerClockLayout.getMeasuredWidth() - 2)
                    speedX[0] = -speedX[0];
                if (positionY[0] <= 2 || positionY[0] >= outerClockLayout.getMeasuredHeight() - innerClockLayout.getMeasuredHeight() - 2)
                    speedY[0] = -speedY[0];

                // Set the position of the innerClockLayout.
                params.leftMargin = positionX[0];
                params.topMargin = positionY[0];

                // Remove the old innerClockLayout and add the new innerClockLayout to the outerClockLayout.
                outerClockLayout.removeAllViews();
                outerClockLayout.addView(innerClockLayout, params);

                // Schedule this runnable to execute again.
                handler.postDelayed(this, 1);
            }
        };

        // Use the handler to execute the runnable.
        handler.postDelayed(runnable, 1);
    }

    /**
     * When this activity is paused, stop the runnable.
     */
    @Override
    protected void onPause() {
        super.onPause();

        // Stop the handler from executing the runnable.
        handler.removeCallbacks(runnable);
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
