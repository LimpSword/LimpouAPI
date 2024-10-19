package fr.alexandre.limpouapi.api.impl;

import fr.alexandre.limpouapi.api.ServerAPI;
import fr.alexandre.limpouapi.config.DefaultConfig;
import fr.alexandre.limpouapi.player.ServerPlayer;
import org.bukkit.Bukkit;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ServerAPIImpl implements ServerAPI {

    private final Map<String, ServerPlayer> serverPlayers = new HashMap<>();

    @Override
    public ServerPlayer getPlayer(UUID uuid) {
        return serverPlayers.get(uuid.toString());
    }

    @Override
    public String identifier() {
        String configIdentifier = DefaultConfig.getInstance().getIdentifier();
        if (configIdentifier != null && !configIdentifier.equals("unknown") && !configIdentifier.isEmpty()) {
            return configIdentifier;
        }
        return Bukkit.getServer().getName();
    }

    public void addPlayer(ServerPlayer serverPlayer) {
        serverPlayers.put(serverPlayer.getUuid().toString(), serverPlayer);
    }

    public void removePlayer(UUID uuid) {
        serverPlayers.remove(uuid.toString());
    }
}
