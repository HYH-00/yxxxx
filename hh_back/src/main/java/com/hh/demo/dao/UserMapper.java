package com.hh.demo.dao;

import com.hh.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    public List<User> queryByidandpwd(String id,String pwd);
}
