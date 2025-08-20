package me.smughito.goldrush.game;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class DepositListener implements Listener {
    private final Plugin plugin;
    public DepositListener(Plugin plugin){ this.plugin = plugin; }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        if (e.getClickedBlock() == null) return;
        Block b = e.getClickedBlock();
        if (b.getType() != Material.DISPENSER) return;

        Player p = e.getPlayer();
        if (p.getInventory().contains(Material.GOLD_INGOT)) {
            p.getInventory().removeItem(new ItemStack(Material.GOLD_INGOT, 1));
            // TODO: map player -> team (přes GameAPI) a přidat bod týmu
            // např. GameAPI.getArenaForPlayer(p).getTeamOf(p).addScore(1);
            p.sendMessage("Deposited 1 gold!");
        } else {
            p.sendMessage("Nemáš ingot.");
        }
    }
}
