package com.hh.demo.dao;

import com.hh.demo.pojo.Comment;
import com.hh.demo.pojo.Fabulous;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    public List<Comment> queryCommentByWechatmomentsId(int id);
    public int insertComment(Comment comment);
}
