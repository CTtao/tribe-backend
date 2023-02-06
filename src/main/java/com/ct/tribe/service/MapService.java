package com.ct.tribe.service;

import com.ct.tribe.common.Result;
import com.ct.tribe.domain.Hero;
import com.ct.tribe.domain.Map;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author weicup
* @description 针对表【map】的数据库操作Service
* @createDate 2023-02-06 14:07:28
*/
public interface MapService extends IService<Map> {
    Result<List<Map>> listMap();

    Result<Map> mapDetail(Long mapId);
}
