package org.myspringmvcdemo.web.servlet;

import java.util.List;


/**
 * ClassName: HandlerExecutionChain
 * Package: org.myspringmvcdemo.web.servlet
 * Description:
 *
 */
public class HandlerExecutionChain {
    private Object handler;
    private List<HandlerInterceptor> interceptorList;
    private int interceptorIndex = -1;

    public HandlerExecutionChain() {
    }

    public HandlerExecutionChain(Object handler, List<HandlerInterceptor> interceptorList) {
        this.handler = handler;
        this.interceptorList = interceptorList;
    }

    public Object getHandler() {
        return handler;
    }

    public void setHandler(Object handler) {
        this.handler = handler;
    }

    public List<HandlerInterceptor> getInterceptorList() {
        return interceptorList;
    }

    public void setInterceptorList(List<HandlerInterceptor> interceptorList) {
        this.interceptorList = interceptorList;
    }

    public int getInterceptorIndex() {
        return interceptorIndex;
    }

    public void setInterceptorIndex(int interceptorIndex) {
        this.interceptorIndex = interceptorIndex;
    }
}
