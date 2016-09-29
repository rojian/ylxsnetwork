
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
import java.util.List;

/**
 * 通过板块查询Article数据
 * Created by Administrator on 2016/9/26.
 */
@WebServlet("/indexServlet")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//       resp.setHeader("Content-type","text/html;charset=utf-8");

        PrintWriter out =resp.getWriter();
        String plate=req.getParameter("plate");
//        System.out.println(plate);
        Gson gson=new Gson();
        ArticleDao articleDao=new ArticleDao();
        List<Article> articles=articleDao.selectArticleByPlate(plate);
//        System.out.println(articles.get(1).getUptime());
        String jsonObjects=gson.toJson(articles);
        out.write(jsonObjects);
    }
}
