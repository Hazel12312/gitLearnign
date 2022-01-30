package com.example.service;

import com.example.mapper.LoginMapper;
import com.example.pojo.Admin;
import com.example.pojo.Log;
import com.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service   //业务层  组件
public class LoginService {

    @Autowired
    private LoginMapper loginMapper;
    private User user;

    //用户登入
    public User login(String name, String password) {
        user = loginMapper.findUser(name, password);
        if (user != null) {
            loginMapper.insertLog(new Log("查询", 0, user.getUser_id()));
        }
        return user;
    }

    //管理员登入
    public boolean adminLogin(String name, String password) {
        Admin admin = loginMapper.findAdmin(name, password);
        if (admin != null) {
            return true;
        }
        return false;
    }

    //存款
    public boolean inputMoney(double money) {
        int i = loginMapper.addBalance(money, user.getUser_id());
        if (i != 0) {
            loginMapper.insertLog(new Log("存款", money, user.getUser_id()));
            return true;
        }
        return false;
    }

    //取款
    public boolean outputMoney(double money) {
        //判断余额是否足够
        if (money > user.getBalance()) {
            System.out.println("余额不足，取款失败");
        } else {
            int i = loginMapper.deleteBalance(money, user.getUser_id());
            if (i != 0) {
                loginMapper.insertLog(new Log("取款", money, user.getUser_id()));
                return true;
            }
        }
        return false;
    }

    //转账
    public boolean transfer(String name, double money) {
        User user2 = loginMapper.findUserByName(name);
        if (user2 != null) {
            if (user.getBalance() > money){
                loginMapper.deleteBalance(money, user.getUser_id());
                loginMapper.addBalance(money, user2.getUser_id());
                loginMapper.insertLog(new Log("转出", money, user.getUser_id()));
                loginMapper.insertLog(new Log("转入", money, user2.getUser_id()));
                return true;
            }
            else {
                System.out.println("余额不足");
                return false;
            }
        } else {
            System.out.println("转账对象不存在");
            return false;
        }
    }

    //查看我的日志
    public List<Log> myLog() {
        List<Log> logs = loginMapper.selectMyLog(user.getUser_id());
        return logs;
    }

    //该用户是否存在
    public boolean findUserByName(String name){
        User user2 = loginMapper.findUserByName(name);
        if (user2 != null){
            return true;
        }
        return false;
    }

    //注册
    public void register(User user){
        loginMapper.insertUser(user);
    }
}
