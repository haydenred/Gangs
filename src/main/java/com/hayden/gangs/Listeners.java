package com.hayden.gangs;

import com.hayden.gangs.gang.Gang;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class Listeners implements Listener {

    private final Main plugin;

    public Listeners(Main plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void blockBreak(BlockBreakEvent event) {
        System.out.println("block break");
        Gang g = plugin.getGangStorage().getGang("OCI");
        g.getBlocksBrokenStatistic().addValue(1);
        plugin.getGangStorage().addGang(g);
    }

}
