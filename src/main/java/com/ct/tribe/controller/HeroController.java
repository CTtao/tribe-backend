package com.ct.tribe.controller;

import com.ct.tribe.common.Result;
import com.ct.tribe.domain.Hero;
import com.ct.tribe.domain.vo.SimpleHeroVO;
import com.ct.tribe.service.HeroService;
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
@RequestMapping("/hero")
public class HeroController {
    @Resource
    private HeroService heroService;

    /**
     * 英雄列表
     * @param tribeId
     * @return
     */
    @GetMapping("/list/{tribeId}")
    public Result<List<Hero>> listHeroByTribeId(@PathVariable Long tribeId){
        return heroService.listHero(tribeId);
    }

    /**
     * 获取单个英雄的详细信息
     * @param heroId
     * @return
     */
    @GetMapping("/detail/{heroId}")
    public Result<Hero> heroDetail(@PathVariable Long heroId){
        return heroService.heroDetail(heroId);
    }
}
