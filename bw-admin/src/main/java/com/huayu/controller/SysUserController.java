package com.huayu.controller;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huayu.dto.SysUserDTO;
import com.huayu.entity.SysUser;
import com.huayu.service.SysUserService;
import com.huayu.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/sys/sysUser")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    /**
     * 分页查询user数据
     * @return
     */
    @GetMapping("/list")
    public R<Page<SysUser>> pageSysUser(Page<SysUser> page, SysUserDTO user){
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        if (ObjectUtil.isNotNull(user)) {
            if(ObjectUtil.isNotNull(user.getKeyword())){
                wrapper.and(i -> i.like("username",user.getKeyword()).or().like("nick_name",user.getKeyword()));
            }
            if (ObjectUtil.isNotNull(user.getGender())) {
                wrapper.eq("gender",user.getGender());
            }
        }
        Page<SysUser> pageUsers = sysUserService.page(page,wrapper);
        return R.success(pageUsers);
    }

    /**
     * 新增用户数据
     * @param sysUser
     * @return
     */
    @PostMapping("/saveUser")
    public R<Boolean> saveSysUser(@RequestBody @Validated SysUser sysUser){
        SysUser sysUser1 = sysUserService.getOne(new LambdaQueryWrapper<SysUser>().eq(SysUser::getPhone, sysUser.getPhone()));
        if (ObjectUtil.isNull(sysUser1)) {
            //指定用户名就为用户电话
            sysUser.setUsername(sysUser.getPhone());
            return R.success( sysUserService.save(sysUser)).setMsg("数据库新增成功");
        }
       return R.error("用户已存在");
    }

    /**
     * 用户数据修改
     * @param sysUser
     * @return
     */
    @PutMapping("/updUser")
    public R<String> updUser(@RequestBody @Validated SysUser sysUser){
        SysUser existingUser =  sysUserService.getOne(new LambdaQueryWrapper<SysUser>().eq(SysUser::getPhone, sysUser.getPhone()));
        if(ObjectUtil.isNotNull(existingUser) && !existingUser.getId().equals(sysUser.getId())){
            return R.error("电话已经存在....");
        }
        // if(ObjectUtil.isNotNull(existingUser) && existingUser.getPhone().equals(sysUser.getPhone())){：会出现自己无法修改自己的情况
        //     return R.error("电话已经存在....");
        // }
        sysUserService.updateById(sysUser);
        return R.success("修改成功...");
    }

    /**
     * 删除用户数据
     * @return
     */
    @DeleteMapping("/delUserbyIds")
    public R<Boolean> delUserbyIds(String ids){
        if (ObjectUtil.isNull(ids)) {
            return R.error("最少有一个ID");
        }
        String[] split = ids.split(",");
        List<String> strings = Arrays.asList(split);
        return R.success( sysUserService.removeByIds(strings));
    }
}
