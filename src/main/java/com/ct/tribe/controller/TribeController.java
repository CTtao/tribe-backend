package com.ct.tribe.controller;

import com.ct.tribe.common.Result;
import com.ct.tribe.domain.Tribe;
import com.ct.tribe.service.TribeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author CT
 * @description
 */
@RestController
@RequestMapping("/tribe")
public class TribeController {
    @Resource
    private TribeService tribeService;

    @PostMapping("/createTribe")
    public Result<Tribe> createTribe(@RequestBody String tribeName, @RequestBody String avatar){
        return tribeService.createTribe(tribeName,avatar);
    }
}
