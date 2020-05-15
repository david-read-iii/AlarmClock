package com.read.alarmclock.Utils;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;

import com.read.alarmclock.Activities.ScreenSaverActivity;

public class ScreenSaverTimer {

    private Handler handler;
    private Runnable runnable;
    private Context context;
    private int time;

    /**
     * Creates a timer that starts the screen saver and provides methods to manipulate that timer.
     * @param time The time in milliseconds to wait before starting the screen saver.
     */
    public ScreenSaverTimer(final Context context, int time) {

        // Initialize new Handler object.
        handler = new Handler();

        // Initialize new Runnable object to start the screen saver when timer is up.
        runnable = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(context, ScreenSaverActivity.class);
                context.startActivity(intent);
            }
        };

        this.context = context;
        this.time = time;
    }

    /**
     * Starts the timer.
     */
    public void startTimer() {
        handler.postDelayed(runnable, time);
    }

    /**
     * Stops the timer.
     */
    public void stopTimer() {
        handler.removeCallbacks(runnable);
    }

    /**
     * Resets the timer.
     */
    public void resetTimer() {
        stopTimer();
        startTimer();
    }

}
