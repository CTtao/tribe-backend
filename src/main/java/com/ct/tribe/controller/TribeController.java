package com.ct.tribe.controller;

import com.ct.tribe.common.Result;
import com.ct.tribe.domain.Map;
import com.ct.tribe.domain.Tribe;
import com.ct.tribe.domain.request.CreateTribeRequest;
import com.ct.tribe.service.TribeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
    public Result<Tribe> createTribe(@RequestBody CreateTribeRequest createTribeRequest){
        String tribeName = createTribeRequest.getTribeName();
        String avatar = createTribeRequest.getAvatar();
        return tribeService.createTribe(tribeName,avatar);
    }
    /**
     * 获取部落详情
     * @return
     */
    @GetMapping("/detail/{tribeId}")
    public Result<Tribe> getTribeDetail(@PathVariable Long tribeId){
        return tribeService.getTribeDetail(tribeId);
    }
}
