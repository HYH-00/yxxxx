package com.hh.demo.service;

import com.hh.demo.dao.TreeHoleMapper;
import com.hh.demo.pojo.TreeHole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreeHoleService {
    @Autowired
    TreeHoleMapper treeHoleMapper;
    public List<TreeHole> getTreeHoleByuserId(String userId){
        return treeHoleMapper.getTreeHoleByuserId(userId);
    }

    public int addTreeHole(TreeHole treeHole){
        return treeHoleMapper.addTreeHole(treeHole);
    }

    public int delTreeHoleByuserId(String userId){
        return treeHoleMapper.delTreeHoleByuserId(userId);
    }

    public int updTreeHoleByuserId(TreeHole treeHole){
        return treeHoleMapper.updTreeHoleByuserId(treeHole);
    }
}
