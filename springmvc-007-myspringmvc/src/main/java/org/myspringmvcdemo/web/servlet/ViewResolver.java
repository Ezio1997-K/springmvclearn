package org.myspringmvcdemo.web.servlet;

import java.util.Locale;

/**
 * ClassName: ViewResolver
 * Package: org.myspringmvcdemo.web.servlet
 * Description:负责将逻辑视图名转换为物理视图名，最终创建View接口的实现类，即视图实现类对象。
 *
 */
public interface ViewResolver {
    /**
     * 解析逻辑视图名称，返回视图对象
     * @param viewName
     * @param locale
     * @return
     * @throws Exception
     */
    View resolveViewName(String viewName, Locale locale) throws Exception;
}
