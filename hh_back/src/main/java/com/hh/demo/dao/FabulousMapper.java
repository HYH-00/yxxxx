package com.hh.demo.dao;

import com.hh.demo.pojo.Fabulous;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FabulousMapper {
    public List<Fabulous> queryFabulousByWechatmomentsId(int id);
    public int insertFabulous(Fabulous fabulous);
    public int deleteFabulousBywIdAndNick(int id,String Nick);
}
