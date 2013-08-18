package org.springframework.samples.mvc.fastjson;

import java.lang.annotation.*;

/**
 * User: matianyi
 * Date: 13-8-18
 * Time: 下午9:59
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FastJson {
}
