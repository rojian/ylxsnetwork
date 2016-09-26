package com.tosit.ylxs.entity;

import java.util.Date;

/**
 * 文章封装
 * Created by Administrator on 2016/9/26.
 */
public class Article {
    private int id;  //文件id
    private  String plate; //板块
    private String title; //标题
    private String brief; //简介
    private String content; //详细内容
    private String path; //图片路径
    private Date uptime; //上传时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getUptime() {
        return uptime;
    }

    public void setUptime(Date uptime) {
        this.uptime = uptime;
    }
}
