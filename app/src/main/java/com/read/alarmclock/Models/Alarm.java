package com.read.alarmclock.Models;

import java.sql.Time;

public class Alarm {

    private Time alarmTime;
    private Boolean enabled;

    public Alarm(Time alarmTime, Boolean enabled) {
        this.alarmTime = alarmTime;
        this.enabled = enabled;
    }

    public Time getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(Time alarmTime) {
        this.alarmTime = alarmTime;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
