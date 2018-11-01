package kaeseth.tools.valid;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
@Inherited
@Documented
@Constraint(validatedBy = {NotNullElementValidator.class})
public @interface NotSameElement {
	String message() default "集合内的存在相同的元素";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
