package me.smughito.goldrush.game;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class XPGenerator {
    private final Plugin plugin;
    private final Location center;
    private final double radius;
    private final int xpPerSecond;

    public XPGenerator(Plugin plugin, Location center, double radius, int xpPerSecond) {
        this.plugin = plugin; this.center = center; this.radius = radius; this.xpPerSecond = xpPerSecond;
        start();
    }

    private void start() {
        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    if (p.getWorld().equals(center.getWorld()) && p.getLocation().distance(center) <= radius) {
                        p.giveExp(xpPerSecond);
                    }
                }
            }
        }.runTaskTimer(plugin, 0L, 20L);
    }
}
