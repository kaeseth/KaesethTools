package com.kaeseth.tools.valid;

import org.springframework.stereotype.Component;

//import lombok.extern.slf4j.Slf4j;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 用于检验列表和数组内是否存在为空的元素的注解的校验实现
 * 
 * 如果元素是字符串，则元素是""(空字符串)和元素为NULL都是非法的
 * 
 * @author kaeseth
 * @since 2019-09-29
 * @version 1.0
 */
//@Slf4j
@Component
public class NotNullElementValidator implements ConstraintValidator<NotNullElement,Object> {
    @Override
    public void initialize(NotNullElement constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
        //log.debug("列表或数组非空元素校验");
        if(object==null){
            //log.debug("对象为空");
            return true;
        }else{
            if(object.getClass().isArray()){
                //log.debug("对象是数组");
                Object[] array=(Object[])object;
                if(array.length>0){
                    for (Object temp:array){
                        if(temp==null){
                            return false;
                        }else{
                            if(temp instanceof String){
                                String str=(String)temp;
                                if(str.length()<1){
                                    return false;
                                }
                            }
                        }
                    }
                }
            }else{
                if(object instanceof List<?>){
                    //log.debug("对象是列表");
                    List<?> list=(List<?>)object;
                    if(!list.isEmpty()){
                        for (Object temp : list){
                            if(temp==null){
                                return false;
                            }else{
                                if(temp instanceof String){
                                    String str=(String)temp;
                                    if(str.length()<1){
                                        return false;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return true;
    }

}

