package fr.alexandre.limpouapi.player;

import lombok.Getter;

import java.util.UUID;

public class ServerPlayer {

    @Getter
    private final UUID uuid;

    public ServerPlayer(UUID uuid) {
        this.uuid = uuid;
    }
}
