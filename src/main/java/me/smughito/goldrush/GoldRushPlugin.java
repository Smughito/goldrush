package me.smughito.goldrush;

import org.bukkit.plugin.java.JavaPlugin;
import me.smughito.goldrush.game.GameListenerRegistrar;

public class GoldRushPlugin extends JavaPlugin {

    private static GoldRushPlugin INSTANCE;

    @Override
    public void onLoad() {
        INSTANCE = this;
    }

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getLogger().info("GoldRush enabling...");

        // TODO: inicializace GameAPI - uprav podle skutečné třídy v GameAPI
        // Příklad (pokud GameAPI má GameApi api = new GameApi(this)):
        // GameApi api = new GameApi(this);
        // api.init(this);

        // Registrace listenerů / příkazů
        GameListenerRegistrar.registerAll(this);

        // Registrace příkazu shop a setup
        getCommand("goldshop").setExecutor(new me.smughito.goldrush.game.ShopCommand(this));
        getCommand("goldrush").setExecutor(new me.smughito.goldrush.game.ArenaSetupCommand(this));

        getLogger().info("GoldRush enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("GoldRush disabling...");
        // api.shutdown(); // pokud je třeba
    }

    public static GoldRushPlugin getInstance() { return INSTANCE; }
}
