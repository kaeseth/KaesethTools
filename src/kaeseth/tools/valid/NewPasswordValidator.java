package kaeseth.tools.valid;

import org.springframework.stereotype.Component;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

@Component
public class NewPasswordValidator implements ConstraintValidator<NewPassword,String> {
    @Override
    public void initialize(NewPassword constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        String lettleNumberFallLine="^[\\w]+$";//数字字母下划线
        String notChinese="^[^\\u3400-\\u9fff]+$";//非方块字，中文韩文日文
        String notBlank="^[^\\s]+$";//非不可打印字符
        //String regex="^([A-Z]|[a-z]|[0-9]|[`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“'。，、？]){3,20}$";
        //Pattern pwdPattern=Pattern.compile(regex);
        //return s==null||s.equals("")||pwdPattern.matcher(s).matches();
        if(s==null||s.equals("")){
            return true;
        }
        Pattern lettleNumberFallLinePattern=Pattern.compile(lettleNumberFallLine);
        if(lettleNumberFallLinePattern.matcher(s).matches()){
            return true;
        }else{
            Pattern notChinesePattern=Pattern.compile(notChinese);
            Pattern notBlankPattern=Pattern.compile(notBlank);
            return notChinesePattern.matcher(s).matches()&&notBlankPattern.matcher(s).matches();
        }
    }
}
