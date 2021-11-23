package com.jdaltonlins.simplerest.factory.server.function;

public interface TypeVerify<T> {

    boolean isValid(String value);

    T parse(String value);

}
