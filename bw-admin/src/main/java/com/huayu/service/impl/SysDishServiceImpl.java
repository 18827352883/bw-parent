package com.huayu.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.dto.SysDishCategoryDTO;
import com.huayu.entity.SysDish;
import com.huayu.service.SysDishService;
import com.huayu.mapper.SysDishMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Page<SysDishCategoryDTO> queryAll(Page<SysDishCategoryDTO> page) {
        sysDishMapper.queryAll(page);
        return null;
    }
}




