package com.jdaltonlins.simplerest.server;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Response {

    private Map<String, List<String>> headers;
    private int status;
    private byte[] content;

    public Response status(int status) {
        this.status = status;
        return this;
    }

    public Response body(byte[] content) {
        setHeader("content-length", String.valueOf(this.content.length));
        this.content = content;
        return this;
    }

    public Response message(String msg) {
        setHeader("content-type", "text/html");
        addHeader("content-type", "charset=utf-8");
        return body(msg.getBytes(StandardCharsets.UTF_8));
    }

    public Response json(Object... values) {
        if (values.length % 2 == 1) throw new IllegalStateException("values need be key and value");
        Map<String, Object> json = new HashMap<String, Object>();
        for (int i = 0; i < values.length; i += 2) {
            json.put(String.valueOf(values[i]), i);
        }
        return this.json(json);
    }

    public Response json(Object obj) {
        setHeader("content-type", "text/html");
        addHeader("content-type", "charset=utf-8");
        String msg = "";
        return body(msg.getBytes(StandardCharsets.UTF_8));
    }

    public Response addHeader(String key, String value) {
        this.headers.computeIfAbsent(key, e -> new ArrayList<>(2)).add(value);
        return this;
    }

    public Response setHeader(String key, String value) {
        this.headers.compute(key, (a,e) -> new ArrayList<>(2)).add(value);
        return this;
    }
}
