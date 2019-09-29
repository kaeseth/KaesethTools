package com.kaeseth.tools.valid;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

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
