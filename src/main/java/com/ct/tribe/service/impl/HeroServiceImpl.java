package com.ct.tribe.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ct.tribe.domain.Hero;
import com.ct.tribe.service.HeroService;
import com.ct.tribe.mapper.HeroMapper;
import org.springframework.stereotype.Service;

/**
* @author CTtao
* @description 针对表【hero】的数据库操作Service实现
* @createDate 2023-01-23 18:12:05
*/
@Service
public class HeroServiceImpl extends ServiceImpl<HeroMapper, Hero>
    implements HeroService{

}




