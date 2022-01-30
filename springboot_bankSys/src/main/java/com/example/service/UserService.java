package com.example.service;

import com.example.mapper.UserMapper;
import com.example.pojo.Log;
import com.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  //业务层
public class UserService {
    @Autowired  //Spring的注解  注入
    private UserMapper userMapper;

    public List<User> selectAllUser() {
        List<User> users = userMapper.selectAllUser();
        return users;
    }

    public List<Log> selectAllLog() {
        List<Log> logs = userMapper.selectAllLog();
        return logs;
    }

    public void lock(int id){
        userMapper.lock(id);
    }

    public void unlock(int id){
        userMapper.unlock(id);
    }

}
