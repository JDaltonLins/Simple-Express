package com.jdaltonlins.simplerest.server;

import com.jdaltonlins.simplerest.HttpMethod;

import java.util.Map;

public class Request {

    private HttpMethod method;
    private String[] path;
    private Map<String, String> headers;

    public HttpMethod getMethod() {
        return method;
    }

    public String[] getPath() {
        return path;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public Response status(int status) {
        return null;
    }

    public Response send(Object data) {
        return null;
    }

}
