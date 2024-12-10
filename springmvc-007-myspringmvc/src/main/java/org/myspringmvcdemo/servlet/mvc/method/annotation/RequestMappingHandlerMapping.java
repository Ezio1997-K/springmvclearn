package org.myspringmvcdemo.servlet.mvc.method.annotation;

import jakarta.servlet.http.HttpServletRequest;
import org.myspringmvcdemo.web.servlet.HandlerExecutionChain;
import org.myspringmvcdemo.web.servlet.HandlerMapping;

/**
 * ClassName: RequestMappingHandlerMapping
 * Package: org.myspringmvcdemo.servlet.mvc.method.annotation
 * Description:
 *
 */
public class RequestMappingHandlerMapping implements HandlerMapping {
    @Override
    public HandlerExecutionChain getHandler(HttpServletRequest request) throws Exception {

        return null;
    }
}
