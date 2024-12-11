package org.myspringmvcdemo.web.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.myspringmvcdemo.web.constant.Const;

import java.io.IOException;

/**
 * ClassName: DispatcherServlet
 * Package: org.myspringmvcdemo.web.servlet
 * Description:前端控制器
 * 在整个Spring MVC执行流程中，负责中央调度。
 */
public class DispatcherServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        //初始化Spring IoC容器
        ServletConfig servletConfig = this.getServletConfig();
        String contextCongfigLocation = servletConfig.getInitParameter(Const.CONTEXT_CONFIG_LOCATION);
        System.out.println(contextCongfigLocation);
        if (contextCongfigLocation.trim().startsWith(Const.CLASSPATH)) {
            String path = Thread.currentThread().getContextClassLoader().getResource(contextCongfigLocation.substring(Const.CLASSPATH.length())).getPath();
            System.out.println(path);
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doDispatch(req, resp);
    }

    private void doDispatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理用户请求
    }

}
