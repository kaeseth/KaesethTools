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
 * 用于检查列表或数组内是否有相同的元素的方法.
 * 
 * <p>
 * 只支持基本数据类型和字符串.
 * </p>
 * 
 * <p>
 * 要要支持自定义的类，需要重写类的toString(){@link Object.toString()}方法，使不同的元素
 * 返回不同的字符串.
 * </p>
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
public @interface NotSameElement {
	String message() default "集合内的存在相同的元素";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
