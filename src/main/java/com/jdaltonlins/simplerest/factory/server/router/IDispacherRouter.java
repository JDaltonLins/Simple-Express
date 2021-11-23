package com.jdaltonlins.simplerest.factory.server.router;

public interface IDispacherRouter extends IIndexRouter {

    String[] EMPTY = new String[0];

    default IDispacherRouter add(IDispacherRouter router) {
        return this.add(EMPTY, router);
    }

    default IDispacherRouter add(String path, IDispacherRouter router) {
        return add(path.split("/"), router);
    }

    default IDispacherRouter add(String[] path, IDispacherRouter router) {
        return add(path, path.length, 0, router);
    }

    IDispacherRouter add(String[] path, int length, int index, IDispacherRouter router);

}
