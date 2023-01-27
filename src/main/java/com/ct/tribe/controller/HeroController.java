package com.ct.tribe.controller;

import com.ct.tribe.common.Result;
import com.ct.tribe.domain.Hero;
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

    @GetMapping("/list/{tribeId}")
    public Result<List<Hero>> listHeroByTribeId(@PathVariable Long tribeId){
        return heroService.listHeroByTribeId(tribeId);
    }
}
