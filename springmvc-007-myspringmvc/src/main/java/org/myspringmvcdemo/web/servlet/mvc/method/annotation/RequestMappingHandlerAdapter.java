package org.myspringmvcdemo.web.servlet.mvc.method.annotation;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.myspringmvcdemo.web.servlet.HandlerAdapter;
import org.myspringmvcdemo.web.servlet.ModelAndView;

/**
 * ClassName: RequestMappingHandlerAdapter
 * Package: org.myspringmvcdemo.web.servlet.mvc.method.annotation
 * Description:
 *
 */
public class RequestMappingHandlerAdapter implements HandlerAdapter {
    @Override
    public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        return null;
    }
}
