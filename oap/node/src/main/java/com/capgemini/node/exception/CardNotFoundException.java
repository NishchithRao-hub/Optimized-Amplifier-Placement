package com.capgemini.node.exception;

public class CardNotFoundException extends RuntimeException{
    public CardNotFoundException(String msg){
        super(msg);
    }
}
