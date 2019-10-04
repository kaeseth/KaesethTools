package com.kaeseth.tools.valid;

import java.util.Arrays;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

/**
 * 用于校验给定的值是否存在于指定的列表中的校验类.
 *
 * @author kaeseth
 * @version 1.0
 */
@Component
public class InListValidator implements ConstraintValidator<InList, Object> {

    private List<String> list = null;
    private String separator = null;

    @Override
    public void initialize(InList constraintAnnotation) {
        this.list = Arrays.asList(constraintAnnotation.list());
        this.separator = constraintAnnotation.separator();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (this.list == null || this.list.isEmpty()) {
            throw new NullPointerException("未指定合法的元素列表");
        } else if(value==null){
            return true;
        }else{
            Class type = value.getClass();
            if (type.isArray()) {
                Object[] array = (Object[]) value;
                if (array.length > 0) {
                    for (Object object : array) {
                        if (object != null) {
                            String str = object.toString();
                            if (str != null) {
                                if (!this.list.contains(str)) {
                                    return false;
                                }
                            }
                        }
                    }
                }
            } else if (value instanceof List<?>) {
                List<?> tempList = (List<?>) value;
                if (!tempList.isEmpty()) {
                    for (Object object : tempList) {
                        if (object != null) {
                            String str = object.toString();
                            if (str != null) {
                                if (!this.list.contains(str)) {
                                    return false;
                                }
                            }
                        }
                    }
                }
            } else if (value instanceof String) {
                String str = value.toString();
                if (str != null) {
                    if (this.separator != null && this.separator.length() > 0) {
                        String[] array = str.split(this.separator);
                        if (array != null && array.length > 0) {
                            for (String tempStr : array) {
                                if (!this.list.contains(tempStr)) {
                                    return false;
                                }
                            }
                        }
                    } else {
                        if (!this.list.contains(str)) {
                            return false;
                        }
                    }

                }
            } else {
                String str = value.toString();
                if (str != null) {
                    if (!this.list.contains(str)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
