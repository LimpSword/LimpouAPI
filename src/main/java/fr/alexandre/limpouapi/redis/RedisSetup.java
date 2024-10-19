package fr.alexandre.limpouapi.redis;

import fr.alexandre.limpouapi.config.DefaultConfig;
import fr.alexandre.limpouapi.redis.cache.InstancesStates;

public final class RedisSetup {

    private static boolean isSetup = false;

    private RedisSetup() {
        throw new UnsupportedOperationException("This class cannot be instantiated");
    }

    public static void setup() {
        if (isSetup) {
            return;
        }

        isSetup = true;

        DefaultConfig defaultConfig = DefaultConfig.getInstance();
        RedisConnection redisConnection = new RedisConnection(defaultConfig.getRedisHost(), defaultConfig.getRedisPort(), defaultConfig.getRedisDatabase(), defaultConfig.getRedisPassword());
        redisConnection.connect();

        new InstancesStates(redisConnection);
    }
}
