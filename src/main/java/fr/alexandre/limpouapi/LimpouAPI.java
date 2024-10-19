package fr.alexandre.limpouapi;

import fr.alexandre.limpouapi.api.BaseAPI;
import fr.alexandre.limpouapi.api.ProxyAPI;
import fr.alexandre.limpouapi.api.ServerAPI;
import fr.alexandre.limpouapi.api.impl.ProxyAPIImpl;
import fr.alexandre.limpouapi.api.impl.ServerAPIImpl;
import fr.alexandre.limpouapi.exceptions.IncompatibleRequestedAPI;
import fr.alexandre.limpouapi.exceptions.UnknownRequestedAPI;
import fr.alexandre.limpouapi.internal.plugins.ProxyPlugin;
import fr.alexandre.limpouapi.internal.plugins.ServerPlugin;
import lombok.Getter;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public final class LimpouAPI {

    @Getter
    private final static LimpouAPI instance = new LimpouAPI();

    private final Map<Class<? extends BaseAPI>, BaseAPI> apis = new HashMap<>();

    public @Nullable <T extends BaseAPI> T getAPI(Class<T> api) throws UnknownRequestedAPI, IncompatibleRequestedAPI {
        if (api == null) {
            throw new UnknownRequestedAPI("The requested API is null.");
        }
        if (!BaseAPI.class.isAssignableFrom(api)) {
            throw new IncompatibleRequestedAPI("The requested API is not compatible with the BaseAPI interface.");
        }
        if (apis.containsKey(api)) {
            return (T) apis.get(api);
        }

        if (api == ProxyAPI.class) {
            if (!ProxyPlugin.isInitialized) {
                throw new IncompatibleRequestedAPI("The ProxyAPI is not available on this server.");
            }
            ProxyAPIImpl proxyAPI = new ProxyAPIImpl();
            apis.put(api, proxyAPI);
            return (T) proxyAPI;
        } else if (api == ServerAPI.class) {
            if (!ServerPlugin.isInitialized) {
                throw new IncompatibleRequestedAPI("The ServerAPI is not available on this server.");
            }
            ServerAPIImpl serverAPI = new ServerAPIImpl();
            apis.put(api, serverAPI);
            return (T) serverAPI;
        }
        throw new UnknownRequestedAPI("The requested API is not registered.");
    }
}
