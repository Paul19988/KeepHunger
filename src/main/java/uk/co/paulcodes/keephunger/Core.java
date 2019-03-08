package uk.co.paulcodes.keephunger;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

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

    @EventHandler
    private static void onDeath(PlayerDeathEvent e) {
        getInstance().getConfig().set(e.getEntity().getUniqueId().toString(), e.getEntity().getFoodLevel());
    }

    @EventHandler
    private static void onRespawn(PlayerRespawnEvent e) {
        e.getPlayer().setFoodLevel((int) getInstance().getConfig().get(e.getPlayer().getUniqueId().toString()));
    }

    public static Core getInstance() { return Core.getPlugin(Core.class); }

}
