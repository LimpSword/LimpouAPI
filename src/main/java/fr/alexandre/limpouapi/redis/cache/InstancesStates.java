package fr.alexandre.limpouapi.redis.cache;

import fr.alexandre.limpouapi.redis.RedisConnection;

import java.util.UUID;

public final class InstancesStates {

    private static RedisConnection redisConnection;

    public InstancesStates(RedisConnection redisConnection) {
        InstancesStates.redisConnection = redisConnection;
    }

    public static boolean isPlayerConnected(UUID uuid) {
        return redisConnection.getJedis().get(uuid.toString()) != null;
    }
}
