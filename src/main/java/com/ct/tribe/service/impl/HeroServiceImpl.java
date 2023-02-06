package com.ct.tribe.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ct.tribe.common.Result;
import com.ct.tribe.constants.HeroConstants;
import com.ct.tribe.constants.TribeConstants;
import com.ct.tribe.domain.Hero;
import com.ct.tribe.domain.vo.SimpleHeroVO;
import com.ct.tribe.mapper.HeroMapper;
import com.ct.tribe.service.HeroService;
import com.ct.tribe.utils.BeanCopyUtils;
import com.ct.tribe.utils.ResultUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author CTtao
* @description 针对表【hero】的数据库操作Service实现
* @createDate 2023-01-23 18:12:05
*/
@Service
public class HeroServiceImpl extends ServiceImpl<HeroMapper, Hero>
    implements HeroService{


    /**
     * @Author CT
     * @Description // 创建Hero
     * @Date 10:04 2023/1/27
     * @Param [tribeId]
     * @return com.ct.tribe.domain.Hero
     **/
    @Override
    public Hero createHero(Long tribeId, int gender) {
        Hero hero = new Hero(tribeId, gender);
        this.save(hero);
        return hero;
    }

    /**
     * @Author CT
     * @Description // 部落创建时初始化英雄
     * @Date 10:05 2023/1/27
     * @Param [tribeId]
     * @return void
     **/
    @Override
    public void initTribeHero(Long tribeId) {
        for (int i = 0; i < TribeConstants.HERO_GENERATE_NUM; i++) {
            int gender = i;
            if(i > 1) gender = RandomUtil.randomInt(0, 2);
            this.createHero(tribeId, gender);
        }
    }

    /**
     * 获取英雄列表
     * @param tribeId
     * @return
     */
    @Override
    public Result<List<Hero>> listHero(Long tribeId) {
        List<Hero> heroList = listHeroByTribeId(tribeId);
//        List<SimpleHeroVO> simpleHeroVOList = BeanCopyUtils.copyBeanList(heroList, SimpleHeroVO.class);
        return ResultUtils.ok(heroList);
    }

    /**
     * 获取单个英雄的详细信息
     * @param heroId
     * @return
     */
    @Override
    public Result<Hero> heroDetail(Long heroId) {
        return ResultUtils.ok(this.getById(heroId));
    }

    /**
     * 根据tribeId获取完整的英雄列表
     * @param tribeId
     * @return
     */
    public List<Hero> listHeroByTribeId(Long tribeId) {
        LambdaQueryWrapper<Hero> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Hero::getTribeId,tribeId);
        return this.list(queryWrapper);
    }

}




