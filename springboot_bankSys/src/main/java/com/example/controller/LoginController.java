package com.example.controller;

import com.example.pojo.Log;
import com.example.pojo.User;
import com.example.service.LoginService;
import com.example.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;
    private User user;

    @RequestMapping("login1")
    public String login(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String encode = MD5.encode(password);

        if (req.getParameter("inlineRadioOptions").equals("option1")) {
            //普通用户
            user = loginService.login(name, encode);
            System.out.println(user);
            System.out.println(user.getBalance());
            System.out.println(user != null && user.getBalance() != 0);
            if (user.getUser_flag() != 0) {
                return "userMain";
            } else {
                return "error";
            }
        } else {
            //管理员
            if (loginService.adminLogin(name, encode)){
                return "adminMain";
            } else {
                return "error";
            }
        }
    }

    //注册
    @RequestMapping("register")
    public String register(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String encode = MD5.encode(password);

        if (req.getParameter("inlineRadioOptions").equals("option1")) {
            //普通用户
            if (!loginService.findUserByName(name)) { // 用户不存在
                loginService.register(new User(name, encode));
                return "success";
            } else {
                System.out.println("注册失败");
                return "error";
            }
        } else {
            //管理员不能注册
            return "error";
        }
    }

    //查询余额
    @RequestMapping("select")
    public String selectMoney(Model model){
        double money = user.getBalance();
        System.out.println("money"+money);
        model.addAttribute("balance", money);
        return "balance";
    }

    //存款
    @RequestMapping("input")
    public String input(){
        return "input";
    }
    @ResponseBody
    @RequestMapping("input2")
    public String inputMoney(HttpServletRequest req){
        double money = Double.parseDouble(req.getParameter("money"));
        boolean b = loginService.inputMoney(money);
        if (b && money > 0) {
            return "存款成功";
        }
        return "存款失败";
    }

    //取款
    @RequestMapping("output")
    public String output(){
        return "output";
    }
    @ResponseBody
    @RequestMapping("output2")
    public String outputMoney(HttpServletRequest req){
        double money = Double.parseDouble(req.getParameter("money"));
        boolean b = loginService.outputMoney(money);
        if (b && money > 0) {
            return "取款成功";
        }
        return "取款失败";
    }

    //转账
    @RequestMapping("transfer")
    public String transfer(){
        return "transfer";
    }
    @ResponseBody
    @RequestMapping("transfer2")
    public String transferMoney(HttpServletRequest req){
        String name = req.getParameter("name");
        double money = Double.parseDouble(req.getParameter("money"));
        if(loginService.transfer(name, money)){
            return "转账成功";
        }
        return "转账失败";
    }

    //查看我的日志
    @RequestMapping("myLog")
    public String myLog(Model model){
        List<Log> logs = loginService.myLog();
        model.addAttribute("myLogs", logs);
        return "myLog";
    }
}
