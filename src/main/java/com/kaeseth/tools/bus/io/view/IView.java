package com.kaeseth.tools.bus.io.view;

import com.kaeseth.tools.bus.io.dto.IResponseData;

/**
 * 后端接口返回给前端的视图.
 * 
 * <p>
 * 不只是传给前端，也可以是内容调用返回的数据视图。
 * </p>
 * 
 * <p>
 * 视图有两两种特点，一个是和前端交互，传递给前端，另一个是必须从数据库中查数据。
 * 对于视图来说，有人建议要只能从数据库查实体，从代码中组合成视图，再传给前端，
 * 即不能从数据库中直接查视图。但对于那些比较复杂的关联查询，不如直接从数据库中直接查出来。
 * </p>
 * 
 * @author kaeseth
 */
public interface IView extends IResponseData{
    
}
