package com.jdaltonlins.simplerest.factory.server.function;

import com.jdaltonlins.simplerest.HttpMethod;
import com.jdaltonlins.simplerest.factory.server.router.IDispacherRouter;
import com.jdaltonlins.simplerest.factory.server.router.RouterContext;
import com.jdaltonlins.simplerest.server.Request;
import com.jdaltonlins.simplerest.server.Response;

import java.lang.reflect.Method;
import java.util.Map;

;

public class FunctionRequest implements IDispacherRouter {

    private Map<String, Param> params;
    private Method method;
    private int allowedMethods;
    private Object instance;
    private int paramsNeed;

    public Map<String, Param> getParams() {
        return params;
    }

    public Method getMethod() {
        return method;
    }

    public int getAllowedMethods() {
        return allowedMethods;
    }

    public Object getInstance() {
        return instance;
    }

    public int getParamsNeed() {
        return paramsNeed;
    }

    @Override
    public boolean dispacher(RouterContext context) {
        Request request = context.getRequest();
        int bitMethod = request.getMethod().getRaw();

        if((request.getMethod().getRaw() & bitMethod) != bitMethod) {
            return false;
        }


        Object[] values = new Object[this.method.getParameterCount()];
        if (this.method.getParameterTypes()[0] == Request.class) {
            values[0] = request;
        }
        for (Map.Entry<String, Param> entry : params.entrySet()) {
            Param param = entry.getValue();
            String value = request.getHeaders().get(param.getName());
            if(value != null) {
                values[param.getIndex()] = param.getVerify().parse(value);
            } else if(param.isNeed()) {
                request.status(403);
                return false;
            }
        }
        try {
            Object value = method.invoke(instance, values);
            if (value == null) {
                request.status(404);
            }
            if(value.getClass().isAssignableFrom(Response.class)) {

            }
        } catch (Throwable e) {
            return false;
        }
        return false;
    }
}
