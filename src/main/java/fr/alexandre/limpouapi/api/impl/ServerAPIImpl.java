package fr.alexandre.limpouapi.api.impl;

import fr.alexandre.limpouapi.api.ServerAPI;
import fr.alexandre.limpouapi.player.ServerPlayer;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ServerAPIImpl implements ServerAPI {

    private final Map<String, ServerPlayer> serverPlayers = new HashMap<>();

    @Override
    public ServerPlayer getPlayer(UUID uuid) {
        return serverPlayers.get(uuid.toString());
    }

    public void addPlayer(ServerPlayer serverPlayer) {
        serverPlayers.put(serverPlayer.getUuid().toString(), serverPlayer);
    }

    public void removePlayer(UUID uuid) {
        serverPlayers.remove(uuid.toString());
    }
}
