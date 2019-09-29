package com.kaeseth.tools.bus.io.dto;

/**
 * 普通动作参数.
 * 
 * <p>
 * 动作与创建和更新不使用用一个接口，虽然创建和更新也是一种动作，但一般的动作比较轻，只会修改某一个字段，而该字段一般只有可
 * 枚举的有限个值，删除也是一种轻量操作，虽然硬删除会将数据真的从数据库中删除，但轻量应该反应在传递的参数上。
 * </p>
 * 
 * @author kaeseth
 */
public interface IActionDto extends IAlterDto{
    
}
