package com.tosit.ylxs.web.controller;

import com.google.gson.Gson;
import com.tosit.ylxs.dao.ArticleDao;
import com.tosit.ylxs.entity.Article;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 2,3级页面请求
 * Created by Administrator on 2016/9/29.
 */
@WebServlet("*.po")
public class ThreeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      PrintWriter out= resp.getWriter();
        int id = (int) req.getSession().getAttribute("id");
//        System.out.println(id);
        if(id==0){
            id=1;
        }
        ArticleDao articleDao = new ArticleDao();
        Article article = articleDao.selectArticleById(id);
        Gson gson=new Gson();
        String jsonobject=gson.toJson(article);
        out.print(jsonobject);
        out.flush();
    }
}
