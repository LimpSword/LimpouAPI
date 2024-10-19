package fr.alexandre.limpouapi.exceptions;

public class IncompatibleRequestedAPI extends RuntimeException {
    public IncompatibleRequestedAPI(String message) {
        super(message);
    }
}
