package me.smughito.goldrush.game;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class ShopCommand implements CommandExecutor {
    private final Plugin plugin;
    public ShopCommand(Plugin plugin){ this.plugin = plugin; }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if (!(sender instanceof Player)) return true;
        Player p = (Player) sender;
        // otevři GUI - implementace dle tvého GUI systému
        p.sendMessage("Opening shop..."); 
        return true;
    }
}
