package xyz.angeloanan.deathcoordslogger;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class DeathCoordsLogger extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getLogger().log(Level.FINE, "Plugin is activated");
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        getLogger().log(Level.FINE, "Plugin is deactivated");
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerDeath(EntityDeathEvent e) {
        if (e.getEntityType() == EntityType.PLAYER && !e.isCancelled()) {
            Player player = (Player) e.getEntity();
            Location loc = player.getLocation();

            String username = player.getDisplayName();
            int x = loc.getBlockX();
            int y = loc.getBlockY();
            int z = loc.getBlockZ();

            System.out.println(username + " died at " + x + ", " + y + ", " + z );
        }
    }
}
