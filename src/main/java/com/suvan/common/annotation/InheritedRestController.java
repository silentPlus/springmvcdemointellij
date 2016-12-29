package com.suvan.common.annotation;

import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;

/**
 * @author suvan
 * @create 2016-12-28-15:13
 */
@Inherited
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@RestController
public @interface InheritedRestController {
    String value() default "";
}
