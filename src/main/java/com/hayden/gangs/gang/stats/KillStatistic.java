package com.hayden.gangs.gang.stats;

import com.hayden.gangs.gang.Gang;
import com.hayden.gangs.gang.GangStatistic;

import java.util.Map;

public class KillStatistic extends GangStatistic {
    private int value = 0;

    public KillStatistic(Map<String, Object> config) {
        super(config);
    }

    public KillStatistic(int initialValue) {
        super(initialValue);
    }
    @Override
    public String getName() {
        return "Kills";
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public void addValue(int amount) {
        value += amount;
    }
    @Override
    public void setValue(int amount) {
        this.value = amount;
    }
}
