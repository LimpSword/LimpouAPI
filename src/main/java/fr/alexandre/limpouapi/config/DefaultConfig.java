package fr.alexandre.limpouapi.config;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.HashMap;

public final class DefaultConfig {

    private static DefaultConfig instance;
    private YamlConfiguration config;

    private DefaultConfig() {
    }

    private static YamlConfiguration getDefaultConfig() {
        YamlConfiguration config = new YamlConfiguration();
        config.set("redis", new HashMap<>() {
            {
                put("host", "localhost");
                put("port", 6379);
                put("database", 0);
                put("password", "");
            }
        });
        config.set("mysql", new HashMap<>() {
            {
                put("host", "localhost");
                put("port", 3306);
                put("database", "database");
                put("username", "root");
                put("password", "password");
            }
        });
        config.set("identifier", "unknown");
        return config;
    }

    public static DefaultConfig getInstance() {
        if (instance == null) {
            instance = new DefaultConfig();
            File file = new File("config.yml");
            if (!file.exists()) {
                // Create default config
                YamlConfiguration config = getDefaultConfig();
                try {
                    config.save(file);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            instance.config = YamlConfiguration.loadConfiguration(file);
        }
        return instance;
    }

    public <T> T get(String key, T defaultValue) {
        if (!config.contains(key)) {
            return defaultValue;
        }
        return (T) config.get(key);
    }

    public String getRedisHost() {
        return get("redis.host", "localhost");
    }

    public int getRedisPort() {
        return get("redis.port", 6379);
    }

    public int getRedisDatabase() {
        return get("redis.database", 0);
    }

    public String getRedisPassword() {
        return get("redis.password", "");
    }

    public String getMySQLHost() {
        return get("mysql.host", "localhost");
    }

    public int getMySQLPort() {
        return get("mysql.port", 3306);
    }

    public String getMySQLDatabase() {
        return get("mysql.database", "database");
    }

    public String getMySQLUsername() {
        return get("mysql.username", "root");
    }

    public String getMySQLPassword() {
        return get("mysql.password", "password");
    }

    public String getIdentifier() {
        return get("identifier", "unknown");
    }
}
