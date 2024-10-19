package fr.alexandre.limpouapi.redis.cache;

import fr.alexandre.limpouapi.redis.RedisConnection;

import java.util.UUID;

public final class InstancesStates {

    private static final String ONLINE_PLAYERS_KEY = "online_players";
    private static final String ONLINE_PLAYERS_SERVER_KEY = "online_players_server";
    private static final String ONLINE_PLAYERS_PROXY_KEY = "online_players_proxy";

    private static RedisConnection redisConnection;

    public InstancesStates(RedisConnection redisConnection) {
        if (InstancesStates.redisConnection != null) {
            throw new UnsupportedOperationException("This class cannot be instantiated");
        }
        if (redisConnection == null) {
            throw new IllegalArgumentException("RedisConnection cannot be null");
        }
        InstancesStates.redisConnection = redisConnection;
    }

    public static boolean isPlayerConnected(UUID uuid) {
        return redisConnection.getClient().getList(ONLINE_PLAYERS_KEY).contains(uuid.toString());
    }

    public static void addPlayer(UUID uuid) {
        redisConnection.getClient().getList(ONLINE_PLAYERS_KEY).add(uuid.toString());
    }

    public static void removePlayer(UUID uuid) {
        redisConnection.getClient().getList(ONLINE_PLAYERS_KEY).remove(uuid.toString());
    }

    public static String getPlayerServer(UUID uuid) {
        return (String) redisConnection.getClient().getMap(ONLINE_PLAYERS_SERVER_KEY).get(uuid.toString());
    }

    public static void setPlayerServer(UUID uuid, String serverName) {
        redisConnection.getClient().getMap(ONLINE_PLAYERS_SERVER_KEY).put(uuid.toString(), serverName);
    }

    public static void removePlayerServer(UUID uuid) {
        redisConnection.getClient().getMap(ONLINE_PLAYERS_SERVER_KEY).remove(uuid.toString());
    }

    public static String getPlayerProxy(UUID uuid) {
        return (String) redisConnection.getClient().getMap(ONLINE_PLAYERS_PROXY_KEY).get(uuid.toString());
    }

    public static void setPlayerProxy(UUID uuid, String proxyName) {
        redisConnection.getClient().getMap(ONLINE_PLAYERS_PROXY_KEY).put(uuid.toString(), proxyName);
    }

    public static void removePlayerProxy(UUID uuid) {
        redisConnection.getClient().getMap(ONLINE_PLAYERS_PROXY_KEY).remove(uuid.toString());
    }
}
