package com.huayu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springboot启动类
 */
@MapperScan("com.huayu.mapper")
@SpringBootApplication
public class BwAdminApplication {
    /**
     * java-jar
     * @param args 系统启动参数
     */
    public static void main(String[] args) {
        SpringApplication.run(BwAdminApplication.class,args);
    }
}
