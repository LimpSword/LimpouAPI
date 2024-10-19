package fr.alexandre.limpouapi.api;

import fr.alexandre.limpouapi.player.ServerPlayer;

import java.util.UUID;

public interface ServerAPI extends BaseAPI {

    ServerPlayer getPlayer(UUID uuid);

    @Override
    String identifier();
}
