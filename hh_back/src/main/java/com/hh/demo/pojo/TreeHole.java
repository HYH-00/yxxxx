package com.hh.demo.pojo;

import lombok.Data;

@Data
public class TreeHole implements Comparable<TreeHole>{
    private String userId;
    private String title;
    private String content;
    private String time;
    private int treeId;

    @Override
    public int compareTo(TreeHole o) {
        return o.time.compareTo(this.time);
    }
}
