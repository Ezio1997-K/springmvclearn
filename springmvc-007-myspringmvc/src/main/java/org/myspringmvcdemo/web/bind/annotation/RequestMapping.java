package org.myspringmvcdemo.web.bind.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName: RequestMapping
 * Package: org.myspringmvcdemo.web.bind.annotation
 * Description:
 *
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMapping {
    String[] value();
    RequestMethod requestMethod();
}
