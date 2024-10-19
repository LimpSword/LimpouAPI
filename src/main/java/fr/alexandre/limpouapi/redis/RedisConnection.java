package fr.alexandre.limpouapi.redis;

import lombok.Getter;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public final class RedisConnection {

    private final String host;
    private final int port;
    private final int database;
    private final String password;

    @Getter
    private RedissonClient client;

    public RedisConnection(String host, int port, int database, String password) {
        this.host = host;
        this.port = port;
        this.database = database;
        this.password = password;
    }

    public void connect() {
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://" + host + ":" + port)
                .setDatabase(database)
                .setConnectionMinimumIdleSize(1)
                .setSubscriptionConnectionPoolSize(128)
                .setRetryAttempts(3)
                .setRetryInterval(1500)
                .setPassword(password);

        client = Redisson.create(config);
    }
}
