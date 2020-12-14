package com.hh.demo.service;

import com.hh.demo.dao.CommentMapper;
import com.hh.demo.dao.FabulousMapper;
import com.hh.demo.dao.UserMapper;
import com.hh.demo.dao.WechatmomentsMapper;
import com.hh.demo.pojo.Comment;
import com.hh.demo.pojo.Fabulous;
import com.hh.demo.pojo.Wechatmoments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WechatmomentsService {
    @Autowired
    WechatmomentsMapper wechatmomentsMapper;
    @Autowired
    FabulousMapper fabulousMapper;
    @Autowired
    CommentMapper commentMapper;
    public List<Wechatmoments> getWechatmoments(){
        List<Wechatmoments> w=wechatmomentsMapper.getWechatmoments(getRowNum()-10,10);
        int lw=w.size();
        List<Wechatmoments> list=new ArrayList<>();
        for(Wechatmoments item:w){
            item.setFabulousNick(queryFabulousByWechatmomentsId(item.getWechatmomentsId()));
            item.setComment(queryCommentByWechatmomentsId(item.getWechatmomentsId()));
            list.add(item);
        }
        return list;
    }
    public int getRowNum(){
        return wechatmomentsMapper.getRowNum();
    }
    public List<String> queryFabulousByWechatmomentsId(int id){
        List<String> list=new ArrayList<>();
        List<Fabulous> f=fabulousMapper.queryFabulousByWechatmomentsId(id);
        int lf=f.size();
        for(int i=0;i<lf;++i){
            list.add(f.get(i).getUserNick());
        }
        return list;
    }
    public List<Comment> queryCommentByWechatmomentsId(int id){
        return commentMapper.queryCommentByWechatmomentsId(id);
    }
    public int insertComment(Comment comment){
        return commentMapper.insertComment(comment);
    }
}
