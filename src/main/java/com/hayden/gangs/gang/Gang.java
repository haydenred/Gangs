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

public class Gang implements ConfigurationSerializable {

    private final String name;
    private final OfflinePlayer owner;
    private List<OfflinePlayer> members;
    private final DeathStatistic deathStatistic;
    private final KillStatistic killStatistic;
    private final BlocksBrokenStatistic blocksBrokenStatistic;

    public Gang(String name, OfflinePlayer owner, List<OfflinePlayer> members, DeathStatistic deathStatistic, KillStatistic killStatistic, BlocksBrokenStatistic blocksBrokenStatistic) {
        this.name = name;
        this.owner = owner;
        this.members = members;
        this.deathStatistic = deathStatistic;
        this.killStatistic = killStatistic;
        this.blocksBrokenStatistic = blocksBrokenStatistic;
    }

    public String getName() {
        return name;
    }

    public OfflinePlayer getOwner() {
        return owner;
    }

    public List<OfflinePlayer> getMembers() {
        return members;
    }

    public DeathStatistic getDeathStatistic() {
        return deathStatistic;
    }

    public KillStatistic getKillStatistic() {
        return killStatistic;
    }

    public BlocksBrokenStatistic getBlocksBrokenStatistic() {
        return blocksBrokenStatistic;
    }


    //Deserialize
    public Gang(Map<String, Object> config) {
        this.name = (String) config.get("name");
        this.members = (List<OfflinePlayer>) config.get("members");
        this.deathStatistic = (DeathStatistic) config.get("Deaths");
        this.killStatistic = (KillStatistic) config.get("Kills");
        this.blocksBrokenStatistic = (BlocksBrokenStatistic) config.get("BlocksBroken");
        this.owner = Bukkit.getOfflinePlayer(UUID.fromString((String) config.get("owner")));
    }


    //Serialize
    @Override
    public Map<String, Object> serialize() {
        LinkedHashMap result = new LinkedHashMap();
        result.put("name", this.name);
        result.put("owner", this.owner.getUniqueId().toString());
        result.put("members", this.members);
        result.put(this.deathStatistic.getName(), this.deathStatistic);
        result.put(this.killStatistic.getName(), this.killStatistic);
        result.put(this.blocksBrokenStatistic.getName(), blocksBrokenStatistic);
        return result;
    }
}
