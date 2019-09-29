package com.kaeseth.tools.bus.io.dto;

/**
 * 修改一个或多个可枚举的值的参数.
 * 
 * <p>
 * 比如修改某个商品的分类，不是修改状态，商品的分类不是可枚举值，因为分类可以被使用者增加，
 * 可枚举的意思是代码写死的，就这几个值，不在程序运行期间增加和减少.
 * </p>
 * @author kaeseth
 */
public interface IUpdateStatusDto extends IActionDto {
    
}
