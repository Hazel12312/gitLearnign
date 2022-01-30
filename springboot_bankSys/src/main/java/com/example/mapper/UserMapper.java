package com.example.mapper;

import com.example.pojo.Log;
import com.example.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper   //表示这是一个mybatis的mapper类
//@Repository  //dao层
public interface UserMapper {
    List<User> selectAllUser();
    List<Log> selectAllLog();
    void lock(int id);
    void unlock(int id);
}
