package org.myspringmvcdemo.ui;

import java.util.LinkedHashMap;

/**
 * ClassName: ModelMap
 * Package: org.myspringmvcdemo.ui
 * Description:
 *
 */
public class ModelMap<K,V> extends LinkedHashMap<K,V> {
    public ModelMap(){}
    public ModelMap addAttribute(K name, V value){
        put(name,(V) value.toString());
        return this;
    }
}
