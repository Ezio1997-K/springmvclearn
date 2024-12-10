package org.myspringmvcdemo.web.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Map;

/**
 * ClassName: View
 * Package: org.myspringmvcdemo.web.servlet
 * Description:负责将模型数据Model渲染为视图格式（HTML代码），并最终将生成的视图（HTML代码）输出到客户端。
 * （它负责将模板语言转换成HTML代码）
 *
 */
public interface View {
    /**
     * 渲染
     * @param model
     * @param request
     * @param response
     * @throws Exception
     */
    void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
            throws Exception;
}
