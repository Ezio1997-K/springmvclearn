package org.myspringmvcdemo.ui;

import java.util.LinkedHashMap;

/**
 * ClassName: ModelMap
 * Package: org.myspringmvcdemo.ui
 * Description:
 *
 */
public class ModelMap extends LinkedHashMap<Object,String> {
    public ModelMap(){}
    public ModelMap addAttribute(String name, Object value){
        put(name,value.toString());
        return this;
    }
}
