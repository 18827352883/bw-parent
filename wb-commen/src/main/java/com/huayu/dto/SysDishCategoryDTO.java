package com.huayu.dto;

import com.huayu.entity.SysCategory;
import com.huayu.entity.SysDish;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysDishCategoryDTO extends SysDish {

    private SysCategory sysCategory;
}
