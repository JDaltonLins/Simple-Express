package com.jdaltonlins.simplerest.factory.server.router;

import java.util.HashMap;
import java.util.Map;

// TODO: Terminar de fazer o sistema de rotas;
public class Router implements IDispacherRouter {

    private Map<String, Router[]> routerMap = new HashMap<>();
    private IDispacherRouter[] indexRouters;

    @Override
    public boolean dispacher(RouterContext context) {
        if (context.getPaths().length - context.getPathIndex() == 0) {
            IDispacherRouter[] routers = routerMap.get("");
            return true;
        }
        return false;
    }

    @Override
    public IDispacherRouter add(String[] path, int length, int index, IDispacherRouter router) {
        if (length - index == 0) {
            // Index router
            if (this.indexRouters != null) {
                IDispacherRouter[] values = new IDispacherRouter[this.indexRouters.length + 1];
                System.arraycopy(this.indexRouters, 0, values, 0, this.indexRouters.length);
                values[values.length - 1] = router;
                this.indexRouters = values;
            } else this.indexRouters = new IDispacherRouter[]{router};
            return this;
        } else {
            Router[] routers = routerMap.get(path[index]);
            Router routerIndex;
            if (routers == null) routers = new Router[]{new Router()};
            else {
                Router[] values = new Router[routers.length + 1];
                System.arraycopy(routers, 0, values, 0, routers.length);
                values[values.length - 1] = routerIndex = new Router();
            }
            return routerIndex;
        }
    }


}
