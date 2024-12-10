package org.myspringmvcdemo.web.method;

import java.lang.reflect.Method;

/**
 * ClassName: HandlerMethod
 * Package: org.myspringmvcdemo.web.method
 * Description:
 *
 */
public class HandlerMethod {
    //处理器对象
    private Object handler;
    //处理器方法
    private Method method;

    public HandlerMethod() {
    }

    public HandlerMethod(Object handler, Method method) {
        this.handler = handler;
        this.method = method;
    }

    /**
     * 获取
     * @return handler
     */
    public Object getHandler() {
        return handler;
    }

    /**
     * 设置
     * @param handler
     */
    public void setHandler(Object handler) {
        this.handler = handler;
    }

    /**
     * 获取
     * @return method
     */
    public Method getMethod() {
        return method;
    }

    /**
     * 设置
     * @param method
     */
    public void setMethod(Method method) {
        this.method = method;
    }

    public String toString() {
        return "HandlerMethod{handler = " + handler + ", method = " + method + "}";
    }
}
