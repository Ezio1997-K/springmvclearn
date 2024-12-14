package org.myspringmvcdemo.web.servlet.mvc.method.annotation;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import org.myspringmvcdemo.web.constant.Const;
import org.myspringmvcdemo.web.context.WebApplicationContext;
import org.myspringmvcdemo.web.method.HandlerMethod;
import org.myspringmvcdemo.web.servlet.HandlerExecutionChain;
import org.myspringmvcdemo.web.servlet.HandlerInterceptor;
import org.myspringmvcdemo.web.servlet.HandlerMapping;
import org.myspringmvcdemo.web.servlet.mvc.RequestMappingInfo;

import java.util.List;
import java.util.Map;

/**
 * ClassName: RequestMappingHandlerMapping
 * Package: org.myspringmvcdemo.servlet.mvc.method.annotation
 * Description:
 *
 */
public class RequestMappingHandlerMapping implements HandlerMapping {
    // 保存所有的请求映射信息，其中键为RequestMappingInfo，值为HandlerMethod对象，表示请求映射信息与处理器方法的映射关系
    private Map<RequestMappingInfo, HandlerMethod> map;
    public RequestMappingHandlerMapping(Map<RequestMappingInfo, HandlerMethod> map) {
        this.map = map;
    }
    @Override
    public HandlerExecutionChain getHandler(HttpServletRequest request) throws Exception {
        // 1. 解析请求路径和请求方法，封装成RequestMappingInfo对象
        RequestMappingInfo requestMappingInfo = new RequestMappingInfo(request.getServletPath(),request.getMethod());
        HandlerExecutionChain handlerExecutionChain = new HandlerExecutionChain();
        //对比请求信息和处理器映射器定义的请求信息是否相等
        if (map.get(requestMappingInfo) != null) {
            //给处理器执行链绑定处理器
            handlerExecutionChain.setHandler(map.get(requestMappingInfo));
        }
        ServletContext servletContext = request.getServletContext();
        //获取springWeb容器
        WebApplicationContext context = (WebApplicationContext) servletContext.getAttribute(Const.WEB_APPLICATION_CONTEXT);
        List<HandlerInterceptor> interceptors = (List<HandlerInterceptor>) context.getBean(Const.INTERCEPTORS);
        //给处理器执行链绑定拦截器
        handlerExecutionChain.setInterceptorList(interceptors);

        return handlerExecutionChain;
    }
}
