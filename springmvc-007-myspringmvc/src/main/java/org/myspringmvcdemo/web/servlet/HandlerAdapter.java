package org.myspringmvcdemo.web.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * ClassName: HandlerAdapter
 * Package: org.myspringmvcdemo.web.servlet
 * Description:
 *

 */
public interface HandlerAdapter {
    /**
     * 执行处理器方法
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception;
}
