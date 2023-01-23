package com.ct.tribe;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author CT
 * @description
 */
@SpringBootApplication
@MapperScan("com.ct.tribe.mapper")
public class TribeApp {
    public static void main(String[] args) {
        SpringApplication.run(TribeApp.class,args);
    }
}
