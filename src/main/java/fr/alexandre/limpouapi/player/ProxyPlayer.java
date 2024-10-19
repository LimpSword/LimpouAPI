package fr.alexandre.limpouapi.player;

import com.velocitypowered.api.proxy.Player;
import com.velocitypowered.api.proxy.ProxyServer;
import lombok.Getter;

import java.util.UUID;

public class ProxyPlayer {

    private final ProxyServer proxyServer;
    @Getter
    private final UUID uuid;

    public ProxyPlayer(ProxyServer proxyServer, UUID uuid) {
        this.proxyServer = proxyServer;
        this.uuid = uuid;
    }

    public void sendPlayer(String serverName) {
        // Distinguish if player is on this proxy or not
        Player player = proxyServer.getPlayer(uuid).orElse(null);
        if (player != null) {
            player.createConnectionRequest(proxyServer.getServer(serverName).orElse(null)).fireAndForget();
        } else {
            // Send request to correct proxy
        }
    }
}
