package me.smughito.goldrush.game;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class ArenaSetupCommand implements CommandExecutor {
    private final Plugin plugin;
    public ArenaSetupCommand(Plugin plugin){ this.plugin = plugin; }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if (!(sender instanceof Player)) return true;
        Player p = (Player) sender;
        if (args.length == 0) {
            p.sendMessage("/goldrush setlobby | addnuggetspawner ...");
            return true;
        }
        if (args[0].equalsIgnoreCase("setlobby")) {
            Location loc = p.getLocation();
            plugin.getConfig().set("arena.lobby.world", loc.getWorld().getName());
            plugin.getConfig().set("arena.lobby.x", loc.getBlockX());
            plugin.getConfig().set("arena.lobby.y", loc.getBlockY());
            plugin.getConfig().set("arena.lobby.z", loc.getBlockZ());
            plugin.saveConfig();
            p.sendMessage("Lobby set.");
            return true;
        } else if (args[0].equalsIgnoreCase("addnuggetspawner")) {
            // uložíme jednoduše jako seznam map v configu (doporučené: arenas.yml)
            // TODO implementovat přidávání do arenas.yml
            p.sendMessage("Spawner added (TODO: implement save to arenas.yml).");
            return true;
        }
        return true;
    }
}
