package com.read.alarmclock;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextClock;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ClockActivity extends AppCompatActivity {

    String TIME_PATTERN = "h:mm a";
    String TIME_PATTERN_WITH_SECONDS = "h:mm:ss a";
    String DATE_PATTERN = "E, MMM d, yyyy";

    /**
     * When this activity is created, inflate the layout in {@link R.layout#activity_clock}.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);
    }

    /**
     * When this activity is resumed, set the format of each text clock.
     */
    @Override
    protected void onResume() {
        super.onResume();

        // Set the format of the time text clock.
        TextClock textClockTime = findViewById(R.id.clock_time);
        textClockTime.setFormat12Hour(TIME_PATTERN);

        // Set the format of the date text clock.
        TextClock textClockDate = findViewById(R.id.clock_date);
        textClockDate.setFormat12Hour(DATE_PATTERN);
    }

    /**
     * Specifies that the toolbar actions for this activity are specified in
     * {@link R.menu#menu_clock}.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_clock, menu);
        return true;
    }

    /**
     * Defines the click behavior for the toolbar actions in this activity.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.action_alarms:
                // TODO: Remove toast and start the AlarmActivity.
                Toast.makeText(this, "Start AlarmActivity", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_settings:
                // TODO: Remove toast and start the SettingsActivity.
                Toast.makeText(this, "Start SettingsActivity", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

}
