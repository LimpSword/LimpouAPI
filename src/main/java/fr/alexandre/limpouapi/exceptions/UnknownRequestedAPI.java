package fr.alexandre.limpouapi.exceptions;

public class UnknownRequestedAPI extends RuntimeException {

    public UnknownRequestedAPI(String message) {
        super(message);
    }
}
