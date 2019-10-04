package com.kaeseth.tools.valid;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * 用于检验给定的值是否是给定列表的子项的注解.
 * 
 * @author kaeseth
 * @version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
@Inherited
@Documented
@Constraint(validatedBy = {InListValidator.class})
public @interface InList {
    String message() default "给定的值或列表中的值不存在于指定的列表中";
    String[] list() default {};//指定的列表
    String separator() default "";//如果是字符串的话，如果该字符串是多个值，则要指定该值用来分隔值1列表
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
