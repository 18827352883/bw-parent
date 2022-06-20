package com.huayu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huayu.dto.SysDishCategoryDTO;
import com.huayu.entity.SysDish;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author HUANGBOWEN
* @description 针对表【sys_dish(菜品管理)】的数据库操作Service
* @createDate 2022-06-20 16:35:14
*/
public interface SysDishService extends IService<SysDish> {
    Page<SysDishCategoryDTO> queryAll(Page<SysDishCategoryDTO> page);

}
