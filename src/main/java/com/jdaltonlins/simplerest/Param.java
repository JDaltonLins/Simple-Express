package com.jdaltonlins.simplerest;

public @interface Param {

    String name();

    Class target();

    boolean nullable();

}
