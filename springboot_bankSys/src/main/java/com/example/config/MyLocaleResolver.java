package com.example.config;

import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

//地区分解器
public class MyLocaleResolver implements LocaleResolver {

    //解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //获得请求中的语言参数
        String language = request.getParameter("l");
        System.out.println("language = "+language);
        Locale locale = Locale.getDefault();  //获得默认的，如果没有就使用默认的
        //如果请求的链接携带了参数
        if(!("".equals(language)||language==null)){
            //字符串分割  分割成语言，地区
            String[] s = language.split("_");
            locale = new Locale(s[0], s[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
