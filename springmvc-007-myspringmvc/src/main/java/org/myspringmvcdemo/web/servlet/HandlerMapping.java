package org.myspringmvcdemo.web.servlet;

import jakarta.servlet.http.HttpServletRequest;

/**
 * ClassName: HandlerMapping
 * Package: org.myspringmvcdemo.web.servlet
 * Description:
 *
 */
public interface HandlerMapping {
    /**
     * 根据请求获取处理器执行链。
     * @param request
     * @return
     * @throws Exception
     */
    HandlerExecutionChain getHandler(HttpServletRequest request) throws Exception;
}
