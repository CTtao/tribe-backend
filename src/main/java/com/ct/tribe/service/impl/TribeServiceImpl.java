package com.ct.tribe.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ct.tribe.common.Result;
import com.ct.tribe.domain.Tribe;
import com.ct.tribe.service.TribeService;
import com.ct.tribe.mapper.TribeMapper;
import com.ct.tribe.utils.ResultUtils;
import org.springframework.stereotype.Service;

/**
* @author CTtao
* @description 针对表【tribe】的数据库操作Service实现
* @createDate 2023-01-23 11:58:20
*/
@Service
public class TribeServiceImpl extends ServiceImpl<TribeMapper, Tribe>
    implements TribeService{

    @Override
    public Result<Tribe> createTribe(String tribeName, String avatar) {
        //todo 从token中获取部落创建者UserId
        Long userId = 1L;
        //创建Tribe
        Tribe tribe = new Tribe();
        tribe.setTribeName(tribeName);
        tribe.setAvatar(avatar);
        tribe.setUserId(userId);
        tribe.setMapId(1L);
        tribe.setScore(0);
        this.setTribeResource(999,tribe);

        this.save(tribe);
        //todo 创建默认的5个hero
        return ResultUtils.ok(tribe);
    }

    private void setTribeResource(int count,Tribe tribe){
        tribe.setResourceGold(count);
        tribe.setResourceStone(count);
        tribe.setResourceWood(count);
        tribe.setResourceFood(count);
    }
}




