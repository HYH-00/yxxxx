package com.hh.demo.controller;

import com.hh.demo.pojo.Comment;
import com.hh.demo.pojo.Fabulous;
import com.hh.demo.pojo.Wechatmoments;
import com.hh.demo.service.WechatmomentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class WechatmomentsController {
    @Autowired
    WechatmomentsService wechatmomentsService;

    @RequestMapping("getWechatmoments")
    public List<Wechatmoments> getWechatmoments(){
        List list=wechatmomentsService.getWechatmoments();
        return list;
    }
    @RequestMapping("getRowNum")
    public int getRowNum(){
        return wechatmomentsService.getRowNum();
    }
    @RequestMapping("insertComment/{content}/{wechatmomentsId}/{respondents}/{recipient}")
    public int insertComment(@PathVariable String content,@PathVariable int wechatmomentsId,@PathVariable String respondents,@PathVariable String recipient){
        Comment comment=new Comment();
        comment.setCommentId(0);
        comment.setContent(content);
        comment.setWechatmomentsId(wechatmomentsId);
        comment.setRespondents(respondents);
        comment.setRecipient(recipient);
        return wechatmomentsService.insertComment(comment);
    }
    @RequestMapping("insertFabulous/{wechatmomentsId}/{userNick}")
    public int insertFabulous(@PathVariable int wechatmomentsId,@PathVariable String userNick){
        System.out.println("insert");
        Fabulous fabulous=new Fabulous();
        fabulous.setWechatmomentsId(wechatmomentsId);
        fabulous.setUserNick(userNick);
        fabulous.setFabulousId(0);
        return wechatmomentsService.insertFabulous(fabulous);
    }
    @RequestMapping("deleteFabulousBywIdAndNick/{id}/{Nick}")
    public int deleteFabulousBywIdAndNick(@PathVariable int id,@PathVariable String Nick){
        System.out.println("delete");
        return wechatmomentsService.deleteFabulousBywIdAndNick(id,Nick);
    }
}
