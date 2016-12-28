package com.suvan.common.annotation;

import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Inherited;

/**
 * @author suvan
 * @create 2016-12-28-15:13
 */
@Inherited
@RestController
public @interface InheritedRestController {
    String value() default "";
}
