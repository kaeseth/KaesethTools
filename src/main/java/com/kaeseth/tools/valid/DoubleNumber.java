package com.kaeseth.tools.valid;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 检查是否是合适的浮点数的注解
 * 
 * @author kaeseth
 * @since 2019-09-029
 * @version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
@Inherited
@Documented
@Constraint(validatedBy = {DoubleNumberValidator.class})
public @interface DoubleNumber {
    String message() default "浮点数的格式不正确";
    int beforePoint() default 0;
    int afterPoint() default 0;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
