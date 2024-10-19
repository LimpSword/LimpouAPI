package fr.alexandre.limpouapi.internal.plugins;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;

import javax.inject.Inject;

@Plugin(id = "limpouapi", name = "LimpouAPI", version = "1.0")
public final class ProxyPlugin {

    private final ProxyServer proxyServer;

    @Inject
    public ProxyPlugin(ProxyServer proxyServer) {
        this.proxyServer = proxyServer;
    }

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        System.out.println("LimpouAPI has been initialized!");
    }
}
