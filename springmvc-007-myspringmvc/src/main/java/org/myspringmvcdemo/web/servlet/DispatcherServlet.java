package org.myspringmvcdemo.web.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.myspringmvcdemo.web.constant.Const;
import org.myspringmvcdemo.web.context.WebApplicationContext;

import java.io.IOException;
import java.util.Locale;

/**
 * ClassName: DispatcherServlet
 * Package: org.myspringmvcdemo.web.servlet
 * Description:前端控制器
 * 在整个Spring MVC执行流程中，负责中央调度。
 */
public class DispatcherServlet extends HttpServlet {
    private ViewResolver viewResolver;
    private HandlerMapping handlerMapping;
    private HandlerAdapter handlerAdapter;
    @Override
    public void init() throws ServletException {
        //初始化Spring IoC容器
        ServletConfig servletConfig = this.getServletConfig();
        String contextCongfigLocation = servletConfig.getInitParameter(Const.CONTEXT_CONFIG_LOCATION);
        System.out.println(contextCongfigLocation);
        String path = null;
        if (contextCongfigLocation.trim().startsWith(Const.PREFIX_CLASSPATH)) {
            path = Thread.currentThread().getContextClassLoader().getResource(contextCongfigLocation.substring(Const.PREFIX_CLASSPATH.length())).getPath();
            System.out.println(path);
        }
        WebApplicationContext webApplicationContext = new WebApplicationContext(this.getServletContext(),path);
        getServletContext().setAttribute(Const.WEB_APPLICATION_CONTEXT, webApplicationContext);
        //初始化处理器映射器
        this.handlerMapping=((HandlerMapping) webApplicationContext.getBean(Const.HANDLER_MAPPING));
        //初始化处理器适配器
        this.handlerAdapter=((HandlerAdapter) webApplicationContext.getBean(Const.HANDLER_ADAPTER));
        //初始化视图解析器
        this.viewResolver=((ViewResolver) webApplicationContext.getBean(Const.VIEW_RESOLVER));
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doDispatch(req, resp);
    }

    private void doDispatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理用户请求
        try{
            //1.根据请求获取对应的处理器执行链对象
            HandlerExecutionChain mappedHandler =  handlerMapping.getHandler(request);
            //2.根据处理器方法获取对应的处理器适配器对象
            HandlerAdapter ha = this.handlerAdapter;
            //3.执行所有拦截器的preHandle()
            if(!mappedHandler.applyPreHandler(request,response)){
                return;
            }
            //4.执行目标方法，返回视图对象
            ModelAndView mv = ha.handle(request,response,mappedHandler.getHandler());
            //5.执行所有拦截器的postHandle()
            mappedHandler.applyPostHandle(request,response,mv);
            //6.响应
            View view = viewResolver.resolveViewName(mv.getView().toString(), Locale.CHINA);
            view.render(mv.getModel(),request,response);
            //7.执行所有拦截器的afterCompletion()
            mappedHandler.triggerAfterCompleton(request,response,null);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
