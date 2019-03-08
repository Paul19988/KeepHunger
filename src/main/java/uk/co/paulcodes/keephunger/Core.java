package uk.co.paulcodes.keephunger;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public class Core extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        System.out.println("KeepHunger is now enabled!");
    }

    @Override
    public void onDisable() {
        System.out.println("KeepHunger is now disabled!");
    }

    private static HashMap<String, Integer> hungerlvl = new HashMap<>();

    @EventHandler
    private static void onDeath(PlayerDeathEvent e) {
        hungerlvl.put(e.getEntity().getUniqueId().toString(), e.getEntity().getFoodLevel());
    }

    @EventHandler
    private static void onRespawn(PlayerRespawnEvent e) {
        e.getPlayer().setFoodLevel(hungerlvl.get(e.getPlayer().getUniqueId().toString()));
    }

}
