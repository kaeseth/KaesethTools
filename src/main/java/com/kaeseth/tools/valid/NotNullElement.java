package com.kaeseth.tools.valid;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 用于检验列表和数组内是否存在为空的元素的注解
 * 
 * @author kaeseth
 * @since 2019-09-29
 * @version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
@Inherited
@Documented
@Constraint(validatedBy = {NotNullElementValidator.class})
public @interface NotNullElement {
    String message() default "集合内的存在NULL元素";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
