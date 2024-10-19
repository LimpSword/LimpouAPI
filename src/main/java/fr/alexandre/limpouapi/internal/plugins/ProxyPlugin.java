package fr.alexandre.limpouapi.internal.plugins;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;
import fr.alexandre.limpouapi.internal.listeners.ProxyConnectionListeners;
import fr.alexandre.limpouapi.redis.RedisSetup;
import org.slf4j.Logger;

import javax.inject.Inject;

@Plugin(id = "limpouapi", name = "LimpouAPI", version = "1.0")
public final class ProxyPlugin {

    public static boolean isInitialized = false;

    private final ProxyServer proxyServer;
    private final Logger logger;

    @Inject
    public ProxyPlugin(ProxyServer proxyServer, Logger logger) {
        isInitialized = true;

        this.proxyServer = proxyServer;
        this.logger = logger;

        RedisSetup.setup();
    }

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        logger.info("LimpouAPI has been initialized on this proxy.");

        // Register listeners
        proxyServer.getEventManager().register(this, new ProxyConnectionListeners(proxyServer));
    }
}
