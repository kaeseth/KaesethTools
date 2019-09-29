package com.kaeseth.tools.bus.io.service;

/**
 * 内部调用Service.
 * 
 * <p>
 * 内部调用的Service是一种有特殊规定的Service：
 * 1.不得引用任何其他Service，适配器除外，只能引用Dao;
 * 2.提供给其他Service使用，Controller不能使用;
 * 3.不能修改任何数据，只能提供查询服务。
 * </p>
 * 
 * @author kaeseth
 */
public interface IInternalService {
    
}
