package com.kaeseth.tools.bus.io.dto;

/**
 * 对一个或多个数据库实体进行保存的参数.
 * 
 * <p>
 * 因为UpdateDto要求必须有主要实体的ID属性，所以要使用
 * SaveDto，就必须要求UpdateDto内的主要实体ID属性不是必须的。
 * </p>
 * 
 * @author kaeseth 
 */
public interface ISaveDto extends IUpdateDto {
    
}
