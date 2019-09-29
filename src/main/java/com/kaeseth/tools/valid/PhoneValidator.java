package com.kaeseth.tools.valid;

import org.springframework.stereotype.Component;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * 检查是否是合适的手机号的校验类
 * 
 * @author kaeseth
 * @since 2019-09-029
 * @version 1.0
 */
@Component
public class PhoneValidator implements ConstraintValidator<Phone,String> {
    @Override
    public void initialize(Phone constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        String regex="^0?(13[0-9]|14[5678]|15[012356789]|16[6]|17[01235678]|18[0-9]|19[89])[0-9]{8}$";
        Pattern phonePattern=Pattern.compile(regex);
        return s==null||s.length()<1||phonePattern.matcher(s).matches();
    }
}
