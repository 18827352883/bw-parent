package com.huayu.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huayu.entity.SysDish;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huayu.vo.SysDishVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author HUANGBOWEN
* @description 针对表【sys_dish(菜品管理)】的数据库操作Mapper
* @createDate 2022-06-20 16:35:14
* @Entity com.huayu.entity.SysDish
*/
@Mapper
public interface SysDishMapper extends BaseMapper<SysDish> {
    /**
     * 查询菜品信息及对应口味
     * @return
     */
    Page<SysDishVO> queryAll(Page<SysDishVO> page, @Param("sysDishVO") SysDishVO sysDishVO);


}




