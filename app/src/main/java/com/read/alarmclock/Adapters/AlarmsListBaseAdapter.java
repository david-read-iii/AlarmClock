package com.read.alarmclock.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Switch;

import com.read.alarmclock.Models.Alarm;
import com.read.alarmclock.R;

import java.util.ArrayList;

public class AlarmsListBaseAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Alarm> alarms;

    public AlarmsListBaseAdapter(Context context, ArrayList<Alarm> alarms) {
        this.context = context;
        this.alarms = alarms;
    }

    @Override
    public int getCount() {
        return alarms.size();
    }

    @Override
    public Object getItem(int i) {
        return alarms.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null)
            view = LayoutInflater.from(context).inflate(R.layout.item_alarm, viewGroup, false);

        Button alarmTime = view.findViewById(R.id.button_alarm_time);
        Switch enabled = view.findViewById(R.id.switch_enabled);
        Button delete = view.findViewById(R.id.button_delete_alarm);

        Alarm selected = (Alarm) getItem(i);

        alarmTime.setText(selected.getAlarmTime().toString());
        enabled.setChecked(selected.getEnabled());

        return view;
    }
}
