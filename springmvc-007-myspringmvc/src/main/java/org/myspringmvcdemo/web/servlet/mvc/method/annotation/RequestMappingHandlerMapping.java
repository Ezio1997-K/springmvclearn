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
    private Map<RequestMappingInfo, HandlerMethod> map;
    public RequestMappingHandlerMapping(Map<RequestMappingInfo, HandlerMethod> map {
        this.map = map;
    }
    @Override
    public HandlerExecutionChain getHandler(HttpServletRequest request) throws Exception {
        RequestMappingInfo requestMappingInfo = new RequestMappingInfo(request.getServletPath(),request.getMethod());
        HandlerExecutionChain handlerExecutionChain = new HandlerExecutionChain();
        if (map.get(requestMappingInfo) != null) {
            handlerExecutionChain.setHandler(map.get(requestMappingInfo));
        }
        ServletContext servletContext = request.getServletContext();
        WebApplicationContext context = (WebApplicationContext) servletContext.getAttribute(Const.WEB_APPLICATION_CONTEXT);
        List<HandlerInterceptor> interceptors = (List<HandlerInterceptor>) context.getBean(Const.INTERCEPTORS);
        handlerExecutionChain.setInterceptorList(interceptors);

        return handlerExecutionChain;
    }
}
