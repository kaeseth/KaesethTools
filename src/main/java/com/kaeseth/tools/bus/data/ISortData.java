package com.kaeseth.tools.bus.data;

/**
 * 类型数据.
 * 
 * <p>类型数据是为了更好的展示主要数据而添加的附加数据，用于组织管理主要数据.</p>
 * <p>类型数据可排序，可配置是否展示.</p>
 * <p>一般类型数据比较少，规模可控，增加速度和增加规模都比较低.</p>
 * <p>一般是由系统维护人员维护，需提供较快的读取速度，写入速度可控可接受即可.</p>
 * <p>建议采用的排序字段由维护人员自己指定，或采用整数分割即可.</p>
 * 
 * @author kaeseth
 */
public interface ISortData extends IOrderProperty, IShowProperty, IRelationData{
    
}
