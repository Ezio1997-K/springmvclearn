package com.usemymvc.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.myspringmvcdemo.web.servlet.HandlerInterceptor;
import org.myspringmvcdemo.web.servlet.ModelAndView;

/**
 * ClassName: Interceptor2
 * Package: com.usemymvc.interceptors
 * Description:
 *
 * @Author Mitsuha
 * @Create 2024/12/11 15:11
 * @Version 1.0
 */
public class Interceptor2 implements HandlerInterceptor {
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("拦截器2 afterCompletion 执行了！");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截器2 preHandle 执行了");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("拦截器2 postHandle 执行了");
    }
}
