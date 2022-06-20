package com.huayu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 系统用户表

 * @TableName sys_user
 */
@TableName(value ="sys_user")
@Data
public class SysUser implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     * @NotBlank ： 可校验空字符串
     */
    @NotBlank(message = "密码不能为空")
    private String password;

    /**
     * 昵称
     */
    @NotEmpty(message = "昵称不能为空")
    private String nickName;

    /**
     * 头像
     */
    private String userFace;

    /**
     * 1男2女
     */
    @NotNull(message = "性别不能为空")
    private Integer gender;

    /**
     * 电话
     */
    @NotEmpty(message = "电话不能为空")
    private String phone;

    /**
     * 1:启用 0：禁用
     */
    private Integer enable;

    /**
     * 封号：锁定的意思 1锁定 0可用
     */
    @TableField("`lock`")
    private Integer lock;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}