package fr.alexandre.limpouapi.internal.listeners;

import fr.alexandre.limpouapi.LimpouAPI;
import fr.alexandre.limpouapi.api.ServerAPI;
import fr.alexandre.limpouapi.api.impl.ServerAPIImpl;
import fr.alexandre.limpouapi.player.ServerPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import javax.inject.Inject;

public final class ServerConnectionListeners implements Listener {

    private final ServerAPIImpl serverAPI;

    @Inject
    public ServerConnectionListeners() {
        this.serverAPI = (ServerAPIImpl) LimpouAPI.getInstance().getAPI(ServerAPI.class);
    }

    @EventHandler
    public void onLogin(PlayerLoginEvent event) {
        Player player = event.getPlayer();
        serverAPI.addPlayer(new ServerPlayer(player.getUniqueId()));
    }
}
