package com.hh.demo.controller;

import com.hh.demo.pojo.User;
import com.hh.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.soap.Addressing;
import java.util.List;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("queryByidandpwd/{id}/{pwd}")
    public User queryByidandpwd(@PathVariable String id,@PathVariable String pwd){
        List<User> users=userService.queryByidandpwd(id,pwd);
        if(users.size()>0)return users.get(0);
        return new User();
    }
    @RequestMapping("test")
    public User test(){
        User user=new User();
        user.setUserId("123");
        return user;
    }
}
