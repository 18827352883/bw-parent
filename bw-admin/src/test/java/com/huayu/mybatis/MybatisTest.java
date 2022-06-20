package com.huayu.mybatis;

import com.huayu.mapper.SysUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MybatisTest {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Test
    public void TestUser(){
        System.out.println( sysUserMapper.selectList(null));
    }
}
