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
    private ModelMap modelMap;

    public Object getView() {
        return view;
    }

    public void setView(Object view) {
        this.view = view;
    }

    public ModelMap getModelMap() {
        return modelMap;
    }

    public void setModelMap(ModelMap modelMap) {
        this.modelMap = modelMap;
    }

    public ModelAndView(Object view, ModelMap modelMap) {
        this.view = view;
        this.modelMap = modelMap;
    }

    public ModelAndView() {
    }
}
