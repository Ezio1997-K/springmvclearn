package org.myspringmvcdemo.web.servlet.mvc;

import java.util.Objects;

/**
 * ClassName: RequestMappingInfo
 * Package: org.myspringmvcdemo.web.servlet.mvc
 * Description:
 *
 */
public class RequestMappingInfo {
    private String RequestURI;
    private String method;

    public RequestMappingInfo() {
    }

    public RequestMappingInfo(String RequestURI, String method) {
        this.RequestURI = RequestURI;
        this.method = method;
    }

    /**
     * 获取
     * @return RequestURI
     */
    public String getRequestURI() {
        return RequestURI;
    }

    /**
     * 设置
     * @param RequestURI
     */
    public void setRequestURI(String RequestURI) {
        this.RequestURI = RequestURI;
    }

    /**
     * 获取
     * @return method
     */
    public String getMethod() {
        return method;
    }

    /**
     * 设置
     * @param method
     */
    public void setMethod(String method) {
        this.method = method;
    }

    public String toString() {
        return "RequestMappingInfo{RequestURI = " + RequestURI + ", method = " + method + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        RequestMappingInfo that = (RequestMappingInfo) o;
        return Objects.equals(RequestURI, that.RequestURI) && Objects.equals(method, that.method);
    }

    @Override
    public int hashCode() {
        return Objects.hash(RequestURI, method);
    }
}
