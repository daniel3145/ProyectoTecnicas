package org.example.exception;

import java.text.MessageFormat;
public class FactoryNotFoundException extends Exception{
    public FactoryNotFoundException(String name)
    {
        super(MessageFormat.format("No se encontro nombre de fabrica{0}",name ));
    }
}




