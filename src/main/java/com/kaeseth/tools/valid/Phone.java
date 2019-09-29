package com.kaeseth.tools.valid;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 检查是否是合适的手机号的注解
 * 
 * @author kaeseth
 * @since 2019-09-029
 * @version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
@Inherited
@Documented
@Constraint(validatedBy = {PhoneValidator.class})
public @interface Phone {
    String message() default "手机号格式不正确";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
