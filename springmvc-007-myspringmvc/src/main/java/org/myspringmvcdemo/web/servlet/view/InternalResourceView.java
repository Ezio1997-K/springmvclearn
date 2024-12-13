package org.myspringmvcdemo.web.servlet.view;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.myspringmvcdemo.web.servlet.View;

import java.util.Map;
import java.util.function.BiConsumer;

/**
 * ClassName: InternalResourceView
 * Package: org.myspringmvcdemo.web.servlet.view
 * Description:
 *
 */
public class InternalResourceView implements View {
    private String contentType;
    private String path;

    public InternalResourceView() {
    }

    public InternalResourceView(String contentType, String path) {
        this.contentType = contentType;
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType(contentType);
        model.forEach((BiConsumer<String, Object>) request::setAttribute);
        request.getRequestDispatcher(path).forward(request, response);
    }
}
