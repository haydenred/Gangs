package com.hayden.gangs;

import com.hayden.gangs.gang.Gang;
import com.hayden.gangs.gang.stats.BlocksBrokenStatistic;
import com.hayden.gangs.gang.stats.DeathStatistic;
import com.hayden.gangs.gang.stats.KillStatistic;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class GangFactory {

    private final Main plugin;

    public GangFactory(Main plugin) {
        this.plugin = plugin;
    }

    public Gang createGang(OfflinePlayer owner, String name) {
        List<OfflinePlayer> members = new ArrayList<OfflinePlayer>();
        members.add(Bukkit.getOfflinePlayer(owner.getUniqueId()));
        return new Gang(
                name,
                Bukkit.getOfflinePlayer(owner.getUniqueId()),
                members, new DeathStatistic(0),
                new KillStatistic(0),
                new BlocksBrokenStatistic(0)
        );
    }

}
