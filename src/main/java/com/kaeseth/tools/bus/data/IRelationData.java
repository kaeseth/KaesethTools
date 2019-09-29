package com.kaeseth.tools.bus.data;

/**
 * 关系实体.
 * <p>被其他实体中的某个字段引用该实体的ID.</P>
 * <p>被引用的字段是引用实体的外键.</p>
 * <p>该接口规定该被引用字段的名称.</p>
 * <p>当该实体能被其他实体引用时，被引用的字段一定是该实体的主键.</p>
 * <p>当该实体能被引用，则该字段取代GUID字段成为主键，但GUID字段要保留，以防止业务需求.</p>
 * 
 * @author kaeseth
 */
public interface IRelationData {
    
    /**
     * 获取主键
     * @return 主键
     */
    Integer GetId();
    
    /**
     * 设置主键
     * @param id 主键
     */
    void SetId(Integer id);
    
}
