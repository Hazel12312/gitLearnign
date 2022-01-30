package com.example.controller;

import com.example.mapper.UserMapper;
import com.example.pojo.Log;
import com.example.pojo.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller  //控制层
public class AdminController {

    @Autowired//自动 装配
    private UserService userService;

    @RequestMapping("home")   //请求
    public String home(){
        System.out.println("home");
        return "home";  //视图解析器  home.html
    }

    @RequestMapping("all")
    public String allUser(Model model){
        List<User> users = userService.selectAllUser();
        model.addAttribute("userList",users);
        return "all";
    }

    @RequestMapping("log")
    public String log(Model model){
        List<Log> logs = userService.selectAllLog();
        model.addAttribute("logList",logs);
        return "log";
    }

    @ResponseBody   //加了这个注解就不会走视图解析器了，返回的就不是视图
    @RequestMapping("logout")
    public void logout(){
        System.out.println("用户下线");
    }

    @ResponseBody
    @RequestMapping("lock/{id}")
    public String lock(@PathVariable("id") int user_id){
        userService.lock(user_id);
        return "冻结成功";
    }

    @ResponseBody
    @RequestMapping("unlock/{id}")
    public String unlock(@PathVariable("id") int user_id){
        userService.unlock(user_id);
        return "解冻成功";
    }
}
/*
* MVC
* M 模型层
* V 视图层
* C 控制层
*
* dao层          数据层   @Mapper / @Repository
* service层      业务层   @Service
* controller层   控制层   @Controller
*
* @Autowired  属性注入，完成自动装配
* @RequestMapping  请求映射，经过视图解析器解析，返回对应的视图页面
* @ResponseBody   不走视图解析器，直接返回数据
*
* */