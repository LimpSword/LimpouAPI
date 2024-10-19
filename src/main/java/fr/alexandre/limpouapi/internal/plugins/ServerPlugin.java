package fr.alexandre.limpouapi.internal.plugins;

import fr.alexandre.limpouapi.internal.listeners.ServerConnectionListeners;
import fr.alexandre.limpouapi.redis.RedisSetup;
import org.bukkit.plugin.java.JavaPlugin;

public final class ServerPlugin extends JavaPlugin {

    public static boolean isInitialized = false;

    public ServerPlugin() {
        isInitialized = true;

        RedisSetup.setup();
    }

    @Override
    public void onEnable() {
        // Register listeners
        getServer().getPluginManager().registerEvents(new ServerConnectionListeners(), this);

        // Register server

    }

    @Override
    public void onDisable() {

    }
}
