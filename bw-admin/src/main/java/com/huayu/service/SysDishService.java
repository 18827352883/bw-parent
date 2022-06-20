package com.huayu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huayu.entity.SysDish;
import com.baomidou.mybatisplus.extension.service.IService;
import com.huayu.vo.SysDishVO;

/**
* @author HUANGBOWEN
* @description 针对表【sys_dish(菜品管理)】的数据库操作Service
* @createDate 2022-06-20 16:35:14
*/
public interface SysDishService extends IService<SysDish> {
    Page<SysDishVO> queryAll(Page<SysDishVO> page, SysDishVO sysDishVO);

}
