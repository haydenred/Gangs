package com.hayden.gangs.gang.stats;

import com.hayden.gangs.gang.Gang;
import com.hayden.gangs.gang.GangStatistic;

import java.util.Map;

public class BlocksBrokenStatistic extends GangStatistic {

    private int value = 0;

    public BlocksBrokenStatistic(Map<String, Object> config) {
        super(config);
    }
    public BlocksBrokenStatistic(int initialValue) {
        super(initialValue);
    }

    @Override
    public String getName() {
        return "BlocksBroken";
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

    @Override
    public void addValue(int amount) {
        System.out.println("OLD VAL " + this.value);
        this.value = this.value + 1;
        System.out.println("NEW VAL " + this.value);
    }

    @Override
    public void setValue(int amount) {
        System.out.println("setting value " + amount);
        this.value = amount;
        System.out.println("set value " + this.value);

    }

}
