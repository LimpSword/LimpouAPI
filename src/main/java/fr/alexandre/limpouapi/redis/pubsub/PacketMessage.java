package fr.alexandre.limpouapi.redis.pubsub;

import java.util.HashMap;
import java.util.Map;

public class PacketMessage {

    private final Map<String, Object> data = new HashMap<>();

    private String sender;
    private String receiver;
}
