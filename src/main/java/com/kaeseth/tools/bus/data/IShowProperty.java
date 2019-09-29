package com.kaeseth.tools.bus.data;

/**
 *  可展示的属性.
 * 
 *  <p>作为数据的附加属性.</p>
 * <p>
 * 可展示属性说明该记录是否能被除管理系统以外的第三方调用者访问到.
 * </p>
 * @author kaeseth
 */
public interface IShowProperty {
    
    /*
        数据的可展示状态
        如果数据是可展示的，则该数据的部分信息或全部信息可以被任意的第三方调用者获取并展示；
        如果数据不是可显示的，则该数据只能被他的创建者获取和展示。
    */
    
    /**
     * 设置数据的显示状态
     * @param showStatus 显示状态
     */
    void setShowStatus(Boolean showStatus);
    
    /**
     * 获取数据的显示状态
     * @return 显示状态
     */
    Boolean getShowStatus();
    
    
}
