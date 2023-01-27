package com.ct.tribe.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ct.tribe.common.Result;
import com.ct.tribe.constants.HeroConstants;
import com.ct.tribe.domain.Hero;
import com.ct.tribe.mapper.HeroMapper;
import com.ct.tribe.service.HeroService;
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
    public Hero createHero(Long tribeId) {
        Hero hero = new Hero();
        hero.setTribeId(tribeId);
        int gender = RandomUtil.randomInt(0,3);
        hero.setGender(gender);
        hero.setHeroName(initHeroName(gender));
        this.initProps(50,hero);
        this.initSkill(hero);
        hero.setScore(0);
        hero.setAppetite(1.0);
        hero.setStatusId(0);
        hero.setAdvantageId(-1);
        hero.setDisadvantageId(-1);
        hero.setAvatar(initAvatar(gender));

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
        for (int i = 0; i < 5; i++) {
            this.createHero(tribeId);
        }
    }

    /**
     * @Author CT
     * @Description // 英雄列表
     * @Date 10:06 2023/1/27
     * @Param [tribeId]
     * @return com.ct.tribe.common.Result<java.util.List<com.ct.tribe.domain.Hero>>
     **/
    @Override
    public Result<List<Hero>> listHeroByTribeId(Long tribeId) {
        LambdaQueryWrapper<Hero> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Hero::getTribeId,tribeId);
        List<Hero> heroList = this.list(queryWrapper);
        return ResultUtils.ok(heroList);
    }

    /**
     * 随机生成英雄姓名
     * @param gender
     * @return
     */
    private String initHeroName(int gender){
        String lastName = RandomUtil.randomEle(HeroConstants.LAST_NAME);
        String firstName;
        if (gender == 0){
            firstName = RandomUtil.randomEle(HeroConstants.FIRST_NAME_MALE);
        }else if (gender == 1){
            firstName = RandomUtil.randomEle(HeroConstants.FIRST_NAME_FEMALE);
        }else firstName = "other";

        return lastName + firstName;
    }

    /**
     * 初始化英雄属性
     * @param num
     * @param hero
     */
    private void initProps(int num, Hero hero){
        hero.setPropFocus(num);
        hero.setPropFortune(num);
        hero.setPropGlamour(num);
        hero.setPropIntelligence(num);
        hero.setPropPhysique(num);
        hero.setPropPower(num);
    }

    /**
     * 初始化英雄技能等级与经验值
     * @param hero
     */
    private void initSkill(Hero hero){
        hero.setSkillCollectExp(0);
        hero.setSkillCollectLevel(1);
        hero.setSkillDigExp(0);
        hero.setSkillDigLevel(1);
        hero.setSkillFellExp(0);
        hero.setSkillFellLevel(1);
        hero.setSkillHuntExp(0);
        hero.setSkillHuntLevel(1);
    }

    /**
     * 随机生成头像序号
     * @param gender
     * @return
     */
    private int initAvatar(int gender){
        if (gender == 0){
            return RandomUtil.randomInt(0,HeroConstants.MAX_MALE_AVATAR);
        } else if (gender == 1){
            return RandomUtil.randomInt(0,HeroConstants.MAX_FEMALE_AVATAR);
        } else return RandomUtil.randomInt(0,HeroConstants.MAX_OTHER_AVATAR);
    }
}




