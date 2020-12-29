package com.hh.demo.dao;

import com.hh.demo.pojo.TreeHole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TreeHoleMapper {
    public List<TreeHole> getTreeHoleByuserId(String userId);

    public int addTreeHole(TreeHole treeHole);

    public int delTreeHoleByuserId(String userId);

    public int updTreeHoleByuserId(TreeHole treeHole);
}
