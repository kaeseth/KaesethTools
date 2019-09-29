package com.kaeseth.tools.valid;

import org.springframework.stereotype.Component;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class NotNullElementValidator implements ConstraintValidator<NotNullElement,String[]> {
    @Override
    public void initialize(NotNullElement constraintAnnotation) {

    }

    @Override
    public boolean isValid(String[] strings, ConstraintValidatorContext constraintValidatorContext) {
        if(strings!=null&&strings.length>0){
            for(String loop:strings){
                if(loop==null||loop.equals("")){
                    return false;
                }
            }
        }
        return true;
    }

}
