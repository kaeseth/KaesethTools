package com.kaeseth.tools.valid;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 判断密码是否由指定的字符组合而成的注解
 * 
 * @author kaeseth
 * @since 2019-09-29
 * @version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
@Inherited
@Documented
@Constraint(validatedBy = {NewPasswordValidator.class})
public @interface NewPassword {
    String message() default "密码格式不正确";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
