package fr.alexandre.limpouapi.api;

import fr.alexandre.limpouapi.player.ProxyPlayer;

import java.util.UUID;

public interface ProxyAPI extends BaseAPI {

    ProxyPlayer getPlayer(UUID uuid);
}
