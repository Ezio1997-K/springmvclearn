package org.myspringmvcdemo.web.servlet;

import org.myspringmvcdemo.ui.ModelMap;

/**
 * ClassName: ModelAndView
 * Package: org.myspringmvcdemo.web.servlet
 * Description:
 *
 */
public class ModelAndView {
    private Object view;
    private ModelMap model;

    public Object getView() {
        return view;
    }
    public void setViewName(String name){
        setView(name);
    }

    private void setView(Object view) {
        this.view = view;
    }

    public ModelMap getModel() {
        return model;
    }

    public void setModelMap(ModelMap modelMap) {
        this.model = modelMap;
    }

    public ModelAndView(Object view, ModelMap modelMap) {
        this.view = view;
        this.model = modelMap;
    }

    public ModelAndView() {
    }
}
