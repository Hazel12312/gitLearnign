package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration  //配置类
public class MyMvcConfig implements WebMvcConfigurer {
//    //视图跳转
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("login");
//        registry.addViewController("/login").setViewName("login");
//    }
    //往容器中注入组件  自定义的组件就会生效
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}
