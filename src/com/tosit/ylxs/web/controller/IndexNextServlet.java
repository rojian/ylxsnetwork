package com.tosit.ylxs.web.controller;

import com.google.gson.Gson;
import com.tosit.ylxs.entity.Article;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * index下级页面请求
 * 通过id查询数据
 * Created by Administrator on 2016/9/26.
 */
@WebServlet("/index/next/*")
public class IndexNextServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
//        通过id查询Article数据
        int id = Integer.parseInt(req.getParameter("id"));
        Gson gson =new Gson();
        Article article;
        String jsonObject=gson.toJson("article");
//        发送给前端
        out.print(jsonObject);
        out.flush();
    }

}
