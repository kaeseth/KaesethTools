package com.kaeseth.tools.bus.data;

/**
 * 普通的数据.
 * 
 * <p>没有顺序.</p>
 * <p>一般是内部数据，提供系统运行和业务实现的非展示的配置式的数据.</p>
 * 
 * @author kaeseth
 */
public interface INormalData {
    /*
        字段GUID 在数据库中，或在系统中唯一标识该JavaBean的属性
        一般由数据库生成GUID的工具或编程语言自带的功能或第三方类库生成的。
    */
    
    /**
     * 设置GUID
     * @param guid GUID 
     */
    void setGuid(String guid);
    
    /**
     * 获取GUID
     * @return GUID
     */
    String getGuid();
    
    /*
        字段创建人ID，数据所有者，数据创建者，数据的第一用户。
    */
    
    /**
     * 设置数据创建人ID
     * @param createId 数据创建人ID
     */
    void setCreaterId(String createId);
    
    /**
     * 获取数据创建人ID
     * @return 数据创建人ID
     */
    String getCreaterId();
    
    /*
        数据创建时间，该字段在数据库中必须由数据库自己的时间类型存储，
        不允许使用字符串格式和数字格式代替。在程序中需系统必要的数据库
        时间格式和编程语言时间格式相互转化的代码或工具
    */
    
    /**
     * 设置数据创建时间
     * @param createTime  数据创建时间
     */
    void setCreateTime(java.sql.Date createTime);
    
    /**
     * 获取数据创建时间
     * @return 数据创建时间
     */
    java.sql.Date getCreateTime();
    
    /*
        字段 数据的伪删除状态，
        一般的数据不提供直接物理删除的接口。
        且数据的删除状态不允许展示，只能作为sql查询
        的条件。
    */
    
    /**
     * 设置数据的删除状态
     * @param deleteStatus 删除状态
     */
    void setDeleteStatus(Boolean deleteStatus);
    
    /**
     * 获取数据的删除状态
     * @return 删除状态
     */
    Boolean getDeleteStatus();
    
}
