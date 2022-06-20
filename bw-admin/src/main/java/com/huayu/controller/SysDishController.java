package com.huayu.controller;


import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huayu.entity.SysDish;
import com.huayu.vo.SysDishVO;
import com.huayu.service.SysDishService;
import com.huayu.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/sysDish")
public class SysDishController {
    @Autowired
    private SysDishService sysDishService;

    /**
     * 菜品查询
     * @param page
     * @param sysDishVO
     * @return
     */
    @GetMapping("/queryDish")
    public R<Page<SysDishVO>> queryDish(Page<SysDishVO> page, SysDishVO sysDishVO){
        return R.success(sysDishService.queryAll(page, sysDishVO));
    }

    /**
     * 菜品添加
     * @param sysDish
     * @return
     */
    @PostMapping("/saveDish")
    public R<String> saveDish(@RequestBody SysDish sysDish){
        SysDish sysDishOne = sysDishService.getOne(new LambdaQueryWrapper<SysDish>().eq(SysDish::getName, sysDish.getName()));
        if (ObjectUtil.isNull(sysDishOne)) {
            sysDish.setCreateTime(new Date());
            sysDish.setUpdateTime(new Date());
            sysDishService.save(sysDish);
            return R.success("添加成功...");
        }
        return R.error("菜品已存在....");
    }

    /**
     * 菜品修改
     * @return
     */
    @PutMapping("/update")
    public R<String> updateDish(@RequestBody SysDish sysDish){
        SysDish sysDishOne = sysDishService.getOne(new LambdaQueryWrapper<SysDish>().eq(SysDish::getName, sysDish.getName()));
        if (ObjectUtil.isNotNull(sysDishOne) && !sysDish.getId().equals(sysDishOne.getId())) {
            return R.error("存在相同菜品");
        }
        sysDish.setUpdateTime(new Date());
        sysDishService.updateById(sysDish);
        return R.success("修改成功...");
    }

    @DeleteMapping("/delDish")
    public R<String> delDish(String ids){
        if (ObjectUtil.isNull(ids)) {
            R.error("最少有一个ID");
        }
        String[] split = ids.split(",");
        sysDishService.removeBatchByIds(Arrays.asList(split));
        return R.success("删除成功...");
    }

}
