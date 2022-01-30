package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication    //启动类上的注解 自动装配
/*@SpringBootConfiguration
@EnableAutoConfiguration   自动配置
@ComponentScan   扫描
*/
public class SpringbootBankSysApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootBankSysApplication.class, args);
    }

}
