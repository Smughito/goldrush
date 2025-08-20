package me.smughito.goldrush.game;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.inventory.ItemStack;
import java.util.List;

public class GoldSpawner implements Listener {
    private final Plugin plugin;
    public GoldSpawner(Plugin plugin) { this.plugin = plugin; startTask(); }

    private void startTask() {
        long interval = plugin.getConfig().getLong("game.nuggetSpawnInterval", 5L) * 20L;
        double ingotChance = plugin.getConfig().getDouble("game.ingotChance", 0.05);

        new BukkitRunnable(){
            @Override
            public void run() {
                List<?> spawners = plugin.getConfig().getList("spawners", List.of());
                for (Object o : spawners) {
                    // očekáváme mapu x,y,z/world v arenas.yml - tady je ukázkově jednoduché
                    // TODO: načíst skutečné lokace z arenas.yml
                    Location loc = /* načíst z configu */;
                    World world = loc.getWorld();
                    if (world == null) continue;
                    if (Math.random() < ingotChance) {
                        world.dropItemNaturally(loc, new ItemStack(Material.GOLD_INGOT));
                    } else {
                        world.dropItemNaturally(loc, new ItemStack(Material.GOLD_NUGGET));
                    }
                }
            }
        }.runTaskTimer(plugin, 0L, interval);
    }
}
