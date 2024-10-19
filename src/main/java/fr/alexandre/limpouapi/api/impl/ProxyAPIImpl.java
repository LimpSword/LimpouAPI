package fr.alexandre.limpouapi.api.impl;

import com.velocitypowered.api.proxy.ProxyServer;
import fr.alexandre.limpouapi.api.ProxyAPI;
import fr.alexandre.limpouapi.config.DefaultConfig;
import fr.alexandre.limpouapi.player.ProxyPlayer;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class ProxyAPIImpl implements ProxyAPI {

    private final ProxyServer proxyServer;
    private final Map<String, ProxyPlayer> proxyPlayers = new HashMap<>();

    @Inject
    public ProxyAPIImpl(ProxyServer proxyServer) {
        this.proxyServer = proxyServer;
    }

    @Override
    public ProxyPlayer getPlayer(UUID uuid) {
        return proxyPlayers.get(uuid.toString());
    }

    @Override
    public String identifier() {
        return DefaultConfig.getInstance().getIdentifier();
    }

    public void addPlayer(ProxyPlayer proxyPlayer) {
        proxyPlayers.put(proxyPlayer.getUuid().toString(), proxyPlayer);
    }

    public void removePlayer(UUID uuid) {
        proxyPlayers.remove(uuid.toString());
    }
}
