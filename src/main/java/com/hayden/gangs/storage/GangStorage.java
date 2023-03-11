package com.hayden.gangs.storage;

import com.hayden.gangs.Main;
import com.hayden.gangs.gang.Gang;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class GangStorage {

    private final Main plugin;
    private final String STORAGE_PATH = "/storage/";


    public GangStorage(Main plugin) {
        this.plugin = plugin;

        //Create storage folder
        new File(plugin.getDataFolder(), STORAGE_PATH).mkdirs();
    }


    public void addGang(Gang gang) {
        File file = new File(plugin.getDataFolder(), STORAGE_PATH + gang.getName() + ".yml");
        //Create file....
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);
        yamlConfiguration.set("gang", gang);
        try {
            yamlConfiguration.save(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void removeGang(String name) {
        File file = new File(plugin.getDataFolder(), STORAGE_PATH + name + ".yml");
        file.delete();
    }

    public boolean gangExists(String name) {
        return new File(plugin.getDataFolder(), STORAGE_PATH + name + ".yml").exists();
    }

    public Gang getGang(String name) {
        File file = new File(plugin.getDataFolder(), STORAGE_PATH + name + ".yml");
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);
        return (Gang) yamlConfiguration.get("gang");    }

}
