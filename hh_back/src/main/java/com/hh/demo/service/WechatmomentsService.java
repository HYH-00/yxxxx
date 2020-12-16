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

    /**
     * 获取朋友圈数据（全部）
     * @return
     */
    public List<Wechatmoments> getWechatmoments(){
        List<Wechatmoments> w=wechatmomentsMapper.getWechatmoments();
        int lw=w.size();
        List<Wechatmoments> list=new ArrayList<>();
        for(Wechatmoments item:w){
            item.setFabulousNick(queryFabulousByWechatmomentsId(item.getWechatmomentsId()));
            item.setComment(queryCommentByWechatmomentsId(item.getWechatmomentsId()));
            list.add(item);
        }
        return list;
    }

    /**
     * 获取朋友圈数据数
     * @return
     */
    public int getRowNum(){
        return wechatmomentsMapper.getRowNum();
    }

    /**
     * 查询对应朋友圈消息的点赞
     * @param id
     * @return
     */
    public List<String> queryFabulousByWechatmomentsId(int id){
        List<String> list=new ArrayList<>();
        List<Fabulous> f=fabulousMapper.queryFabulousByWechatmomentsId(id);
        int lf=f.size();
        for(int i=0;i<lf;++i){
            list.add(f.get(i).getUserNick());
        }
        return list;
    }

    /**
     * 查询对应朋友圈消息的评论
     * @param id
     * @return
     */
    public List<Comment> queryCommentByWechatmomentsId(int id){
        return commentMapper.queryCommentByWechatmomentsId(id);
    }

    /**
     * 添加评论
     * @param comment
     * @return
     */
    public int insertComment(Comment comment){
        return commentMapper.insertComment(comment);
    }

    /**
     * 添加点赞
     * @param fabulous
     * @return
     */
    public int insertFabulous(Fabulous fabulous){
        return fabulousMapper.insertFabulous(fabulous);
    }

    /**
     * 删除点赞
     * @param id
     * @param Nick
     * @return
     */
    public int deleteFabulousBywIdAndNick(int id,String Nick){
        return fabulousMapper.deleteFabulousBywIdAndNick(id,Nick);
    }
}
