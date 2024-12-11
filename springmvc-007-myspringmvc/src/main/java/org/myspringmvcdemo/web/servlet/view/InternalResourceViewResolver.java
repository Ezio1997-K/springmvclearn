package org.myspringmvcdemo.web.servlet.view;

import org.myspringmvcdemo.web.servlet.View;
import org.myspringmvcdemo.web.servlet.ViewResolver;

import java.util.Locale;

/**
 * ClassName: InternalResourceViewResolver
 * Package: org.myspringmvcdemo.web.servlet.view
 * Description:
 *
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
        return null;
    }
}
