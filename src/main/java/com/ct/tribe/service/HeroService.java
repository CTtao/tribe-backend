package com.ct.tribe.service;

import com.ct.tribe.common.Result;
import com.ct.tribe.domain.Hero;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ct.tribe.domain.vo.SimpleHeroVO;

import java.util.List;

/**
* @author CTtao
* @description 针对表【hero】的数据库操作Service
* @createDate 2023-01-23 18:12:05
*/
public interface HeroService extends IService<Hero> {
    Hero createHero(Long tribeId, int gender);

    void initTribeHero(Long tribeId);

    Result<List<SimpleHeroVO>> listHero(Long tribeId);

    Result<Hero> heroDetail(Long heroId);
}
