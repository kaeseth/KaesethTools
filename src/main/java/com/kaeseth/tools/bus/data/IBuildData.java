package com.kaeseth.tools.bus.data;

/**
 * 建筑数据，排楼数据，商品数据.
 * <p>不是建筑物，是不同的人一层一层叠加的数据，比如微博数据，贴吧的帖子等.</p>
 * <p>排楼数据可排序，可设置是否展示.</p>
 * <p>数据量比较大，供任何人观看.</p>
 * <p>排序字段建议采用时间来计算.</p>
 * <p>一般是业务的主要、主体数据，需要比较快的读写速度.</p>
 * <p>具有较较大的增长速度和增长规模.</p>
 * 
 * @author kaeseth
 * @since 2019-09-029
 * @version 1.0
 */
public interface IBuildData extends IOrderProperty,IShowProperty{
    
}
