package com.huayu.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huayu.dto.SysDishCategoryDTO;
import com.huayu.service.SysDishService;
import com.huayu.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sysDish")
public class SysDishController {
    @Autowired
    private SysDishService sysDishService;

    @GetMapping("/query")
    public R<Page<SysDishCategoryDTO>> query(Page<SysDishCategoryDTO> page){
        return R.success(sysDishService.queryAll(page));
    }

}
