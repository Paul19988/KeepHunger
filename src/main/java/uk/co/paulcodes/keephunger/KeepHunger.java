package uk.co.paulcodes.keephunger;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import uk.co.paulcodes.keephunger.listeners.DeathListener;

public class KeepHunger extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new DeathListener(), this);
    }

    @Override
    public void onDisable() {
    }

}
