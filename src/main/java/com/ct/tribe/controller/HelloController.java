package com.ct.tribe.controller;

import com.ct.tribe.common.RedisKey;
import com.ct.tribe.common.Result;
import com.ct.tribe.domain.Tribe;
import com.ct.tribe.service.TribeService;
import com.ct.tribe.utils.RedisCache;
import com.ct.tribe.utils.ResultUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author CT
 * @description
 */
@RestController
public class HelloController {
    @Resource
    private RedisCache redisCache;
    @Resource
    private TribeService tribeService;

    @RequestMapping
    public String hello(){
        return "hello world";
    }

    @GetMapping("/testUtils")
    public Result<Tribe> testUtils(){
        Tribe tribe = new Tribe();
        tribe.setId(-11L);
        tribe.setScore(20000);
        redisCache.setCacheObject(RedisKey.LOGIN_TRIBE + tribe.getId(),tribe);
        return ResultUtils.ok(tribe);
    }

    @GetMapping("/getRedisTribe")
    public Result<Tribe> getRedisTribe(){
        Tribe tribe = redisCache.getCacheObject(RedisKey.LOGIN_TRIBE + "-11");
        return ResultUtils.ok(tribe);
    }

    @GetMapping("/testSaveTribe")
    public Result<Tribe> testSaveTribe(String tribeName, String avatar){
        return tribeService.createTribe(tribeName,avatar);
    }
}
