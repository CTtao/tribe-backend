package com.ct.tribe.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ct.tribe.common.Result;
import com.ct.tribe.domain.Tribe;
import com.ct.tribe.service.HeroService;
import com.ct.tribe.service.TribeService;
import com.ct.tribe.mapper.TribeMapper;
import com.ct.tribe.utils.ResultUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author CTtao
* @description 针对表【tribe】的数据库操作Service实现
* @createDate 2023-01-23 11:58:20
*/
@Service
public class TribeServiceImpl extends ServiceImpl<TribeMapper, Tribe>
    implements TribeService{
    @Resource
    private HeroService heroService;

    @Override
    public Result<Tribe> createTribe(String tribeName, String avatar) {
        //todo 从token中获取部落创建者UserId
        Long userId = 1L;
//        if (tribeIsExist(userId)){
            //todo 测试阶段跳过
//            throw new BusinessException(HttpCode.PARAMS_ERROR,"您已拥有一个部落，无法再次创建");
//        }
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
        heroService.initTribeHero(tribe.getId());
        return ResultUtils.ok(tribe);
    }

    private void setTribeResource(int count,Tribe tribe){
        tribe.setResourceGold(count);
        tribe.setResourceStone(count);
        tribe.setResourceWood(count);
        tribe.setResourceFood(count);
    }

    /**
     * 根据id检查该部落是否存在
     * @param tribeId
     * @return
     */
    private boolean tribeIsExist(Long tribeId){
        LambdaQueryWrapper<Tribe> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Tribe::getId,tribeId);
        long count = this.count(queryWrapper);
        return count > 0;
    }

    /**
     * 获取部落详情
     * @param tribeId
     * @return
     */
    public Result<Tribe> getTribeDetail(Long tribeId) {
        if(tribeIsExist(tribeId)) {
            Tribe tribe = this.getById(tribeId);
            return ResultUtils.ok(tribe);
        }else {
            return ResultUtils.error(400, "无法查找到该部落");
        }
    }

}




