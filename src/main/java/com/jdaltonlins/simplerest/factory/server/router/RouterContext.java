package com.jdaltonlins.simplerest.factory.server.router;

import com.jdaltonlins.simplerest.server.Request;

public class RouterContext {

    private Request request;

    private int pathIndex;
    private String[] paths;

    public RouterContext(Request request, int pathIndex, String[] paths) {
        this.request = request;
        this.pathIndex = pathIndex;
        this.paths = paths;
    }

    public Request getRequest() {
        return request;
    }

    public int getPathIndex() {
        return pathIndex;
    }

    public String[] getPaths() {
        return paths;
    }
}
