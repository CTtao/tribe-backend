package com.ct.tribe.controller;

import com.ct.tribe.common.Result;
import com.ct.tribe.domain.Hero;
import com.ct.tribe.domain.Map;
import com.ct.tribe.domain.vo.SimpleHeroVO;
import com.ct.tribe.service.HeroService;
import com.ct.tribe.service.MapService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author CT
 * @description
 */
@RestController
@RequestMapping("/map")
public class MapController {
    @Resource
    private MapService mapService;

    /**
     * 地图列表
     * @return
     */
    @GetMapping("/list")
    public Result<List<Map>> listHeroByTribeId(){
        return mapService.listMap();
    }
    /**
     * 获取单个英雄的详细信息
     * @param mapId
     * @return
     */
    @GetMapping("/detail/{mapId}")
    public Result<Map> heroDetail(@PathVariable Long mapId){
        return mapService.mapDetail(mapId);
    }
}
