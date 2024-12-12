package org.myspringmvcdemo.web.context;

import jakarta.servlet.ServletContext;
import org.myspringmvcdemo.context.ApplicationContext;

/**
 * ClassName: WebApplicationContext
 * Package: org.myspringmvcdemo.web.web
 * Description:
 *
 */
public class WebApplicationContext extends ApplicationContext {
    private ServletContext servletContext;
    private String contextPath;

    public WebApplicationContext(ServletContext servletContext, String contextPath) {
        super(contextPath);
        this.servletContext = servletContext;
    }

    public ServletContext getServletContext() {
        return servletContext;
    }

    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }
}
