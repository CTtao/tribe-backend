package com.ct.tribe.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ct.tribe.common.Result;
import com.ct.tribe.domain.Map;
import com.ct.tribe.service.MapService;
import com.ct.tribe.mapper.MapMapper;
import com.ct.tribe.utils.ResultUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author weicup
* @description 针对表【map】的数据库操作Service实现
* @createDate 2023-02-06 14:07:28
*/
@Service
public class MapServiceImpl extends ServiceImpl<MapMapper, Map>
    implements MapService{

    /**
     * 获取所有地图的信息
     * @return
     */
    @Override
    public Result<List<Map>> listMap() {
        return ResultUtils.ok(this.list());
    }

    /**
     * 获取单个地图的信息
     * @param mapId
     * @return
     */
    @Override
    public Result<Map> mapDetail(Long mapId) {
        return ResultUtils.ok(this.getById(mapId));
    }
}




