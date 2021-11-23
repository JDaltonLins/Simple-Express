package com.jdaltonlins.simplerest.factory.server.router;

import com.jdaltonlins.simplerest.factory.server.function.FunctionRequest;
import com.jdaltonlins.simplerest.factory.server.function.Param;
import com.jdaltonlins.simplerest.server.Request;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RouterFunctionMatcher implements IDispacherRouter {

    private List<FunctionRequest> matchs;

    public RouterFunctionMatcher(List<FunctionRequest> matchs) {
        this.matchs = matchs;
    }

    public RouterFunctionMatcher() {
        this.matchs = new ArrayList<>(2);
    }

    public List<FunctionRequest> getMatchs() {
        return matchs;
    }

    @Override
    public boolean dispacher(RouterContext context) {
        Request request = context.getRequest();
        FunctionRequest highest = null;
        float matcher = 0, tmp;

        for (FunctionRequest match : matchs) {
            tmp = 0;
            for (Map.Entry<String, Param> e : match.getParams().entrySet()) {
                String value =  request.getHeaders().get(e.getKey());
                if(value != null) {
                    tmp += 1;
                    tmp += e.getValue().getVerify().isValid(value) ? 1 : 0;
                }
            }
            tmp /= match.getParamsNeed() * 2;
            if(tmp > matcher) {
                highest = match;
                matcher = tmp;
            }
        }

        if(highest != null)
            return highest.dispacher(context);
        return false;
    }
}
