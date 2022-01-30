package com.example.mapper;

import com.example.pojo.Admin;
import com.example.pojo.Log;
import com.example.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper   //dao层 组件
public interface LoginMapper {
     User findUser(String user_name, String user_password);
     Admin findAdmin(String admin_name, String admin_password);

     int addBalance(double balance, int user_id);  //存款
     int deleteBalance(double balance, int user_id); //取款
     List<Log> selectMyLog(int userid);  //查看我的日志

     void insertLog(Log log);

     User findUserByName(String user_name);  //查看转账对象是否存在
     void insertUser(User user);  //注册用户

}
