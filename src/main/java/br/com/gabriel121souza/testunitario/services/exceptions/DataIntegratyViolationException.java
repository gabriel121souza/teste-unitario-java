package br.com.gabriel121souza.testunitario.services.exceptions;

public class DataIntegratyViolationException extends RuntimeException{
    public DataIntegratyViolationException(String message) {
        super(message);
    }
}
