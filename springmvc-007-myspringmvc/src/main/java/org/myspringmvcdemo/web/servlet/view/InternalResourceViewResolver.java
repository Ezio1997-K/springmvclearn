package org.myspringmvcdemo.web.servlet.view;

import org.myspringmvcdemo.web.servlet.View;
import org.myspringmvcdemo.web.servlet.ViewResolver;

import java.util.Locale;

/**
 * ClassName: InternalResourceViewResolver
 * Package: org.myspringmvcdemo.web.servlet.view
 * Description:
 */
public class InternalResourceViewResolver implements ViewResolver {
    private String prefix;
    private String suffix;

    public InternalResourceViewResolver(String prefix, String suffix) {
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public InternalResourceViewResolver() {
    }

    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception {
        //根据视图名称解析视图对象，将视图名称拼接为实际的视图路径，并创建InternalResourceView对象，返回。
        return new InternalResourceView("text/html;charset=UTF-8", prefix + viewName + suffix);
    }
}
