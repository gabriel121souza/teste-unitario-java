package br.com.gabriel121souza.testunitario.services.exceptions;

public class ObjectNotFoundException extends  RuntimeException{
    public ObjectNotFoundException(String message){
        super(message);
    }
}
