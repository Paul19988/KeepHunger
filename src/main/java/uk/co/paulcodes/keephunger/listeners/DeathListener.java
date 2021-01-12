package uk.co.paulcodes.keephunger.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import java.util.HashMap;
import java.util.UUID;

public class DeathListener implements Listener {

    private HashMap<UUID, Integer> playerHunger = new HashMap<>();

    @EventHandler
    private void onDeath(PlayerDeathEvent e) {
        Player p = e.getEntity();
        int foodLevel = p.getFoodLevel();
        if(p.hasPermission("keephunger.restorehunger")) {
            playerHunger.put(p.getUniqueId(), foodLevel);
        }
    }

    @EventHandler
    private void onRespawn(PlayerRespawnEvent e) {
        Player p = e.getPlayer();
        if(p.hasPermission("keephunger.restorehunger")) {
            p.setFoodLevel(playerHunger.get(p.getUniqueId()));
        }
    }

}
