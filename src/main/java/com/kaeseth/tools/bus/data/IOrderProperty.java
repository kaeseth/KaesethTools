package com.kaeseth.tools.bus.data;

/**
 * 数据的可排序属性.
 * 
 * <p>数据可通过提供排序字段，自定义排序方法.</p>
 * <p>如果没有该属性，则可以通过创建时间，GUID等提供默认排序.</p>
 * <p>规定排序字段必须是float类型的数据.</p>
 * 
 * @author kaeseth
 */
public interface IOrderProperty {
    
    /**
     * 设置排序数字
     * @param orderNumber  排序数字
     */
    void setOrderNumber(Float orderNumber);
    
    /**
     * 获取排序数字
     * @return 排序数字
     */
    Float getOrderNumber();
    
}
