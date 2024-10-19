package fr.alexandre.limpouapi.api.impl;

import fr.alexandre.limpouapi.api.ProxyAPI;
import fr.alexandre.limpouapi.player.ProxyPlayer;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class ProxyAPIImpl implements ProxyAPI {

    private final Map<String, ProxyPlayer> proxyPlayers = new HashMap<>();

    @Override
    public ProxyPlayer getPlayer(UUID uuid) {
        return proxyPlayers.get(uuid.toString());
    }

    public void addPlayer(ProxyPlayer proxyPlayer) {
        proxyPlayers.put(proxyPlayer.getUuid().toString(), proxyPlayer);
    }

    public void removePlayer(UUID uuid) {
        proxyPlayers.remove(uuid.toString());
    }
}
