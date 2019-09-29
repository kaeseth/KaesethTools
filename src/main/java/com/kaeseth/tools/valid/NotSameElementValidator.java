package com.kaeseth.tools.valid;

import java.util.HashMap;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 用于检查列表和数组内是否存在相同元素的检验类
 *
 *
 * @author kaeseth
 * @since 2019-09-29
 * @version 1.0
 */
@Component
public class NotSameElementValidator implements ConstraintValidator<NotSameElement, Object> {

    @Override
    public void initialize(NotSameElement constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
        if (object == null) {
            return true;
        } else {
            HashMap<String, Integer> map = new HashMap<>();
            int emptryElementCount = 0;

            if (object.getClass().isArray()) {
                //log.debug("对象是数组");
                Object[] array = (Object[]) object;
                if (array.length > 0) {
                    for (Object temp : array) {
                        if (temp == null) {
                            emptryElementCount = emptryElementCount + 1;
                        } else {
                            String tempStr = temp.toString();
                            if (tempStr == null || tempStr.length() < 1) {
                                emptryElementCount = emptryElementCount + 1;
                            } else {
                                Integer tempInt = map.get(tempStr);
                                if (tempInt == null) {
                                    tempInt = 0;
                                    map.put(tempStr, tempInt);
                                } else {
                                    tempInt = tempInt + 1;
                                    map.put(tempStr, tempInt);
                                }
                            }
                        }
                    }
                } else {
                    return true;
                }
            } else {
                if (object instanceof List<?>) {
                    //log.debug("对象是列表");
                    List<?> list = (List<?>) object;
                    if (!list.isEmpty()) {
                        for (Object temp : list) {
                            if (temp == null) {
                                emptryElementCount = emptryElementCount + 1;
                            } else {
                                String tempStr = temp.toString();
                                if (tempStr == null || tempStr.length() < 1) {
                                    emptryElementCount = emptryElementCount + 1;
                                } else {
                                    Integer tempInt = map.get(tempStr);
                                    if (tempInt == null) {
                                        tempInt = 0;
                                        map.put(tempStr, tempInt);
                                    } else {
                                        tempInt = tempInt + 1;
                                        map.put(tempStr, tempInt);
                                    }
                                }
                            }
                        }
                    } else {
                        return true;
                    }
                }
            }

            if (!map.isEmpty()) {
                Set<String> keySet = map.keySet();
                for (String loop : keySet) {
                    Integer count = map.get(loop);
                    if (count > 1) {
                        return false;
                    }
                }
            }

            return emptryElementCount==0;
        }
    }
}
