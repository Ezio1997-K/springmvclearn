package org.myspringmvcdemo.context;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.myspringmvcdemo.stereotype.Controller;
import org.myspringmvcdemo.web.bind.annotation.RequestMapping;
import org.myspringmvcdemo.web.constant.Const;
import org.myspringmvcdemo.web.method.HandlerMethod;
import org.myspringmvcdemo.web.servlet.HandlerAdapter;
import org.myspringmvcdemo.web.servlet.HandlerInterceptor;
import org.myspringmvcdemo.web.servlet.HandlerMapping;
import org.myspringmvcdemo.web.servlet.mvc.RequestMappingInfo;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: ApplicationContext
 * Package: org.myspringmvcdemo.context
 * Description:
 */
public class ApplicationContext {
    private Map<String, Object> beanMap = new HashMap<>();

    public ApplicationContext(String xmlPath) {
        try {
            //解析xml文件
            SAXReader reader = new SAXReader();
            Document document = reader.read(new File(xmlPath));
            //组件扫描
            Element componentScanElement = (Element) document.selectSingleNode("/beans/component-scan");
            Map<RequestMappingInfo, HandlerMethod> map = componentScan(componentScanElement);
            System.out.println("beanMap:" + beanMap);
            //创建视图解析器
            Element beanElement = (Element) document.selectSingleNode("/beans/bean");
            createViewResolver(beanElement);
            //创建所有的拦截器
            Element interceptorsElement = (Element) document.selectSingleNode("/beans/interceptors");
            createInterceptors(interceptorsElement);
            //创建HandlerMapping接口 HandlerAdaptor接口对应的实现类
            createHandlerMappingAdaptor(Const.BASE_PACKAGE_HANDLER,map);
            System.out.println("beanMap:" + beanMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void createHandlerMappingAdaptor(String basePackageHandler,Map<RequestMappingInfo,HandlerMethod> map) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String packagePath = basePackageHandler.replace(".", "/");
        System.out.println(packagePath);
        File file = new File(URLDecoder.decode(Thread.currentThread().getContextClassLoader().getResource(packagePath).getPath(), Charset.forName("UTF-8")));
        File[] files = file.listFiles();
        for (File f : files) {
            if(f.getName().endsWith(Const.SUFFIX_CLASS)){
                String className = basePackageHandler + "." +f.getName().substring(0,f.getName().lastIndexOf("."));
                Class<?> clazz = Class.forName(className);
                //实现了接口才创建对象
                if (HandlerMapping.class.isAssignableFrom(clazz)) {
                    Object object = clazz.getDeclaredConstructor(Map.class).newInstance(map);
                    beanMap.put(Const.HANDLER_MAPPING,object);
                }else if(HandlerAdapter.class.isAssignableFrom(clazz)){
                    Object object = clazz.getDeclaredConstructor().newInstance();
                    beanMap.put(Const.HANDLER_ADAPTER,object);
                }

            }
        }
    }

    private void createInterceptors(Element interceptorsElement) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        List<HandlerInterceptor> interceptors = new ArrayList<>();
        List<Element> beanElements = interceptorsElement.elements(Const.BEAN_TAG_NAME);
        for (Element beanElement : beanElements) {
            Class<?> clazz = Class.forName(beanElement.attributeValue(Const.BEAN_TAG_CLASS_ATTRIBUTE));
            interceptors.add((HandlerInterceptor) clazz.getDeclaredConstructor().newInstance());
        }
        beanMap.put(Const.INTERCEPTORS, interceptors);
    }

    private void createViewResolver(Element beanElement) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        String classValue = beanElement.attributeValue(Const.BEAN_TAG_CLASS_ATTRIBUTE);
        Class<?> clazz = Class.forName(classValue);
        Object viewResolverObject = clazz.getDeclaredConstructor().newInstance();
        List<Element> propertyElements = beanElement.elements(Const.PROPERTY_TAG_NAME);
        for (Element propertyElement : propertyElements) {
            String fieldName = propertyElement.attributeValue(Const.PROPERTY_NAME_ATTRIBUTE);
            String fieldValue = propertyElement.attributeValue(Const.PROPERTY_VALUE_ATTRIBUTE);
            String setMethodName = fieldNameToSetMethodName(fieldName);
            System.out.println("set方法名" + setMethodName);
            clazz.getDeclaredMethod(setMethodName, String.class).invoke(viewResolverObject, fieldValue);
        }
        //添加到IoC容器
        beanMap.put(Const.VIEW_RESOLVER, viewResolverObject);
    }

    private String fieldNameToSetMethodName(String fieldName) {
        return "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
    }

    private Map<RequestMappingInfo,HandlerMethod> componentScan(Element componentScanElement) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //创建处理器映射器大Map
        Map<RequestMappingInfo,HandlerMethod> map = new HashMap<>();
        String packageName = componentScanElement.attribute(Const.BASE_PACKAGE).getValue();
        String packagePath = packageName.replaceAll("\\.", "/");
        String realPath = Thread.currentThread().getContextClassLoader().getResource(packagePath).getPath();
        System.out.println("绝对路径" + realPath);
        //封装为File对象
        File file = new File(realPath);
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.getName().endsWith(Const.SUFFIX_CLASS)) {
                String className = file1.getName().substring(0, file1.getName().lastIndexOf("."));
                System.out.println("类名：" + className);
                String fullClassName = packageName + "." + className;
                System.out.println("全类名" + fullClassName);
                Class<?> clazz = Class.forName(fullClassName);
                if (clazz.isAnnotationPresent(Controller.class)) {
                    Object beanObject = clazz.getDeclaredConstructor().newInstance();
                    beanMap.put(firstCharLowerCase(clazz.getSimpleName()), beanObject);
                    //创建这个bean所有的HandlerMehod对象，并放到大Map中
                    Method[] methods = clazz.getMethods();
                    for (Method method : methods) {
                        if (method.isAnnotationPresent(RequestMapping.class)) {
                            RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
                            RequestMappingInfo requestMappingInfo = new RequestMappingInfo();
                            requestMappingInfo.setRequestURI(requestMapping.value()[0]);
                            requestMappingInfo.setMethod(requestMapping.requestMethod().name());
                            HandlerMethod handlerMethod = new HandlerMethod(beanObject, method);
                            map.put(requestMappingInfo, handlerMethod);
                        }
                    }
                }
            }
        }
        return map;
    }

    private String firstCharLowerCase(String simpleName) {
        return simpleName.substring(0, 1).toLowerCase() + simpleName.substring(1);
    }

    public Object getBean(String beanName) {
        return beanMap.get(beanName);

    }
}
