package com.jdaltonlins.simplerest;

public enum HttpMethod {
    GET, HEAD, POST, PUT, DELETE, CONNECT, OPTIONS, TRACE, PATCH;

    int raw;

    HttpMethod(){
        this.raw = this.ordinal() << 1;
    }

    public int getRaw() {
        return raw;
    }
}
