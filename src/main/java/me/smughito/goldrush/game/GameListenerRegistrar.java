package me.smughito.goldrush.game;

import org.bukkit.plugin.Plugin;

public class GameListenerRegistrar {
    public static void registerAll(Plugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(new GoldSpawner(plugin), plugin);
        plugin.getServer().getPluginManager().registerEvents(new DepositListener(plugin), plugin);
        // XP generator může být task, ne event
    }
}
