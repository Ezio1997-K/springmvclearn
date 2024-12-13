package org.myspringmvcdemo.web.servlet.mvc.method.annotation;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.myspringmvcdemo.ui.ModelMap;
import org.myspringmvcdemo.web.method.HandlerMethod;
import org.myspringmvcdemo.web.servlet.HandlerAdapter;
import org.myspringmvcdemo.web.servlet.ModelAndView;

import java.lang.reflect.Method;

/**
 * ClassName: RequestMappingHandlerAdapter
 * Package: org.myspringmvcdemo.web.servlet.mvc.method.annotation
 * Description:
 */
public class RequestMappingHandlerAdapter implements HandlerAdapter {
    @Override
    public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Object controller = handlerMethod.getHandler();
        Method method = handlerMethod.getMethod();
        ModelMap modelMap = new ModelMap();
        //要求形参必须为ModelMap,返回值为String
        String viewName = (String) method.invoke(controller, modelMap);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewName);
        modelAndView.setModelMap(modelMap);
        return modelAndView;
    }
}
