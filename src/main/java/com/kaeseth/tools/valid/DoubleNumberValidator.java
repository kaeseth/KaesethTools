package com.kaeseth.tools.valid;

import org.springframework.stereotype.Component;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * 检查是否是合适的浮点数的校验类
 *
 * @author kaeseth
 * @since 2019-09-029
 * @version 1.0
 */
@Component
public class DoubleNumberValidator implements ConstraintValidator<DoubleNumber, Object> {

    private int beforePoint;
    private int afterPoint;

    @Override
    public void initialize(DoubleNumber constraintAnnotation) {
        beforePoint = constraintAnnotation.beforePoint();
        afterPoint = constraintAnnotation.afterPoint();
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
        if (object == null) {
            return true;
        } else {
            String s = object.toString();
            if (s == null || s.length() < 1) {
                return true;
            } else {
                String patternStr = "^0\\.\\d+$|^[1-9][0-9]*(\\.\\d+)?|(\\s&&[^\\f\\n\\r\\t\\v])*$";
                Pattern pattern = Pattern.compile(patternStr);
                if (!pattern.matcher(s).matches()) {
                    return false;
                }
                if (s.contains(".")) {
                    String[] temp0 = s.split("\\.");
                    if (temp0.length > 2) {
                        return false;
                    } else {
                        if (temp0.length < 2) {
                            return false;
                        }
                        String temp1 = temp0[0];
                        String temp2 = temp0[1];
                        if (temp1.length() < 1) {
                            return false;
                        }
                        if (beforePoint > 0) {
                            if (temp1.length() > beforePoint) {
                                return false;
                            }
                        }
                        if (temp2.length() < 1) {
                            return false;
                        }
                        if (afterPoint > 0) {
                            if (temp2.length() > afterPoint) {
                                return false;
                            }
                        }
                    }
                } else {
                    if (beforePoint > 0) {
                        if (s.length() > beforePoint) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
