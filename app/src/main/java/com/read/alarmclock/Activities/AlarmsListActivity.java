package com.read.alarmclock.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.read.alarmclock.Adapters.AlarmsListBaseAdapter;
import com.read.alarmclock.Models.Alarm;
import com.read.alarmclock.R;

import java.sql.Time;
import java.util.ArrayList;

public class AlarmsListActivity extends AppCompatActivity {

    private ListView listViewAlarms;
    private BaseAdapter baseAdapterAlarms;
    private ArrayList<Alarm> alarms;
    private FloatingActionButton buttonAddAlarm;

    /**
     * When this activity is created, inflate the layout in {@link R.layout#activity_alarms_list}.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarms_list);

        // Initialize the list view, it's data source, and it's adapter.
        listViewAlarms = findViewById(R.id.list_view_alarms);
        alarms = new ArrayList<>();
        baseAdapterAlarms = new AlarmsListBaseAdapter(this, alarms);

        // Set the adapter of the list view.
        listViewAlarms.setAdapter(baseAdapterAlarms);

        // TODO: Respond to list view clicks.
        listViewAlarms.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(AlarmsListActivity.this, "Item #" + i + " was pressed.", Toast.LENGTH_SHORT).show();
            }
        });

        // Initialize the floating action button.
        buttonAddAlarm = findViewById(R.id.button_add_alarm);

        // TODO: Respond to floating action button clicks.
        buttonAddAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AlarmsListActivity.this, "Start AddAlarmActivity", Toast.LENGTH_SHORT).show();
            }
        });

        // TODO: Remove these sample alarms.
        alarms.add(new Alarm(new Time(510000), true));
        alarms.add(new Alarm(new Time(729878), true));
        alarms.add(new Alarm(new Time(348984), true));
        baseAdapterAlarms.notifyDataSetChanged();
    }
}
