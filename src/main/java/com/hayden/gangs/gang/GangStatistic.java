package com.hayden.gangs.gang;

import com.hayden.gangs.gang.stats.BlocksBrokenStatistic;
import com.hayden.gangs.gang.stats.DeathStatistic;
import com.hayden.gangs.gang.stats.KillStatistic;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.serialization.ConfigurationSerializable;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public abstract class GangStatistic implements ConfigurationSerializable {

    public abstract String getName();
    public abstract Integer getValue();
    public abstract void addValue(int amount);
    public abstract void setValue(int amount);

    public GangStatistic(Integer initialValue) {
        this.setValue(initialValue);
    }
    public GangStatistic(Map<String, Object> config) {
        System.out.println("GET " + config.get("value"));
        this.setValue((Integer) config.get("value"));
    }
    @Override
    public Map<String, Object> serialize() {
        LinkedHashMap result = new LinkedHashMap();
        System.out.println("PUT " + this.getValue());
        result.put("value", this.getValue());
        return result;
    }
}
