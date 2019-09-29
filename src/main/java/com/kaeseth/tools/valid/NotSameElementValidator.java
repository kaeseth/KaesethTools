package com.kaeseth.tools.valid;

import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Set;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class NotSameElementValidator implements ConstraintValidator<NotSameElement,String[]> {
	@Override
    public void initialize(NotSameElement constraintAnnotation) {

    }

    @Override
    public boolean isValid(String[] strings, ConstraintValidatorContext constraintValidatorContext) {
        if(strings!=null&&strings.length>0){
        	HashMap<String, Integer> map=new HashMap<>();
            for(String loop:strings){
                Integer temp=map.get(loop);
                if(temp==null) {
                	temp=new Integer(0);
                	map.put(loop, temp);
                }else {
                	temp=temp+1;
                	map.put(loop, temp);
                }
            }
            if(!map.isEmpty()) {
            	Set<String> keySet=map.keySet();
            	for(String loop:keySet) {
            		Integer count=map.get(loop);
            		if(count>1) {
            			return false;
            		}
            	}
            }
        }
        return true;
    }
}
