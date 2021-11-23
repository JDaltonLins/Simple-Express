package com.jdaltonlins.simplerest.factory.server.function;

public class Param {

    private String name;
    private TypeVerify verify;
    private int index;
    private boolean need, body;

    public Param(String name, TypeVerify verify, int index, boolean need, boolean body) {
        this.name = name;
        this.verify = verify;
        this.index = index;
        this.need = need;
        this.body = body;
    }

    public String getName() {
        return name;
    }

    public TypeVerify getVerify() {
        return verify;
    }

    public int getIndex() {
        return index;
    }

    public boolean isNeed() {
        return need;
    }

    public boolean isBody() {
        return body;
    }
}
