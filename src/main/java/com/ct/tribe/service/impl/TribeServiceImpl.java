package com.ct.tribe.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ct.tribe.domain.Tribe;
import com.ct.tribe.service.TribeService;
import com.ct.tribe.mapper.TribeMapper;
import org.springframework.stereotype.Service;

/**
* @author CTtao
* @description 针对表【tribe】的数据库操作Service实现
* @createDate 2023-01-23 11:58:20
*/
@Service
public class TribeServiceImpl extends ServiceImpl<TribeMapper, Tribe>
    implements TribeService{

}




