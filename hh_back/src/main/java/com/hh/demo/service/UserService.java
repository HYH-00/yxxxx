package com.hh.demo.service;

import com.hh.demo.dao.UserMapper;
import com.hh.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public List<User> queryByidandpwd(String id, String pwd){
        return userMapper.queryByidandpwd(id,pwd);
    }
}
