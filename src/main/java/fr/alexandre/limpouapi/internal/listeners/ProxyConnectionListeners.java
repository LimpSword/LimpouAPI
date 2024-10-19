package fr.alexandre.limpouapi.internal.listeners;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.connection.PostLoginEvent;
import com.velocitypowered.api.proxy.Player;
import com.velocitypowered.api.proxy.ProxyServer;
import fr.alexandre.limpouapi.LimpouAPI;
import fr.alexandre.limpouapi.api.ProxyAPI;
import fr.alexandre.limpouapi.api.impl.ProxyAPIImpl;
import fr.alexandre.limpouapi.player.ProxyPlayer;

import javax.inject.Inject;

public final class ProxyConnectionListeners {

    private final ProxyAPIImpl proxyAPI;
    private final ProxyServer proxyServer;

    @Inject
    public ProxyConnectionListeners(ProxyServer proxyServer) {
        this.proxyAPI = (ProxyAPIImpl) LimpouAPI.getInstance().getAPI(ProxyAPI.class);
        this.proxyServer = proxyServer;
    }

    @Subscribe
    public void onPlayerJoin(PostLoginEvent event) {
        // Player is about to join a server
        Player player = event.getPlayer();
        proxyAPI.addPlayer(new ProxyPlayer(proxyServer, player.getUniqueId()));
    }
}
