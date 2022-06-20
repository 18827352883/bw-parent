package com.huayu.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.entity.SysDish;
import com.huayu.vo.SysDishVO;
import com.huayu.service.SysDishService;
import com.huayu.mapper.SysDishMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
* @author HUANGBOWEN
* @description 针对表【sys_dish(菜品管理)】的数据库操作Service实现
* @createDate 2022-06-20 16:35:14
*/
@Service
public class SysDishServiceImpl extends ServiceImpl<SysDishMapper, SysDish> implements SysDishService{

    @Autowired
    private SysDishMapper sysDishMapper;


    @Override
    public Page<SysDishVO> queryAll(Page<SysDishVO> page, SysDishVO sysDishVO) {
        Page<SysDishVO> sysDishCategoryDTOPage = sysDishMapper.queryAll(page, sysDishVO);
        return sysDishCategoryDTOPage;
    }
}




