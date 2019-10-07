package com.ouyang.lesson.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ouyangduning
 * @date 2019/10/7 15:39
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface BigToStr {
    //小数保留位数，默认2位
    int length() default 2;
}
