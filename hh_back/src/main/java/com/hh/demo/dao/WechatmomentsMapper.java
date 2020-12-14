package com.hh.demo.dao;

import com.hh.demo.pojo.Wechatmoments;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WechatmomentsMapper {
    public List<Wechatmoments> getWechatmoments(int row,int num);
    public int getRowNum();
}
