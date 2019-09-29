package com.kaeseth.tools.bus.data;

/**
 * 拥有父项的实体.
 * 
 * <p>
 * 父项字段一定是该实体父项实体的主键，
 * 父项实体一定是关系实体{@link IRelationData}.
 * 实体有且只能由一个父项实体.
 * </p>
 * 
 * <p>
 * 父项和其他业务关系的字段不同,
 * 比如学生的班级属性，不属于父项，应再添加学生的班级属性.
 * </p>
 * 
 * @author kaeseth
 */
public interface IParentData {
    
    /**
     * 获取父项ID
     * @return 父项ID
     */
    Integer GetParentId();
    
    /**
     * 设置父项ID
     * @param parentId 父项ID
     */
    void SetParentId(Integer parentId);
    
}
