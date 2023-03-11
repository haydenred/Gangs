package com.hayden.gangs;

import com.hayden.gangs.gang.Gang;
import com.hayden.gangs.storage.GangStorage;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;

public class Main extends JavaPlugin {

    private Main plugin;
    private GangStorage gangStorage;
    private GangFactory gangFactory;


    @Override
    public void onEnable() {
        this.plugin = this;
        this.gangStorage = new GangStorage(this);
        this.gangFactory = new GangFactory(this);

        getServer().getPluginManager().registerEvents(new Listeners(this), this);

        gangStorage.addGang(gangFactory.createGang(Bukkit.getOfflinePlayer(UUID.fromString("fefffeed-d067-406b-92ce-2e0ff49743be")), "OCI"));

    }

    public GangStorage getGangStorage() {
        return gangStorage;
    }
}
