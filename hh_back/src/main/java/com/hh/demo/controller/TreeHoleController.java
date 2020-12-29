package com.hh.demo.controller;

import com.hh.demo.pojo.TreeHole;
import com.hh.demo.service.TreeHoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
public class TreeHoleController {
    @Autowired
    TreeHoleService treeHoleService;
    @RequestMapping("getTreeHoleByuserId/{userId}")
    public List<TreeHole> getTreeHoleByuserId(@PathVariable String userId){
//        System.out.println("111");
        List<TreeHole> list= treeHoleService.getTreeHoleByuserId(userId);
        Collections.sort(list);
        System.out.println(list.toString());
        return list;
    }
    @RequestMapping("addTreeHole")
    public int addTreeHole(@RequestBody TreeHole treeHole){
        System.out.println("----");
//        if(treeHole.getTime()==""||treeHole.getTime()==null) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            treeHole.setTime((df.format(new Date())).toString());
//        }
        return treeHoleService.addTreeHole(treeHole);
    }
    @RequestMapping("delTreeHoleByuserId/{userId}")
    public int delTreeHoleByuserId(@PathVariable String userId){
        return treeHoleService.delTreeHoleByuserId(userId);
    }
    @RequestMapping("updTreeHoleByuserId")
    public int updTreeHoleByuserId(@RequestBody TreeHole treeHole){
        System.out.println("----");
        return treeHoleService.updTreeHoleByuserId(treeHole);
    }
}
