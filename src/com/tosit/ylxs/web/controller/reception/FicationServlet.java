package com.tosit.ylxs.web.controller.reception;

import com.google.gson.Gson;
import com.tosit.ylxs.dao.ArticleDao;
import com.tosit.ylxs.dao.UserDao;
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
 * Created by Administrator on 2016/9/30.
 */
@WebServlet("/ficationServlet")
public class FicationServlet extends HttpServlet  {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        String classification=req.getParameter("fication");
        UserDao userDao=new UserDao();
        Gson gson=new Gson();
        ArticleDao articleDao=new ArticleDao();
        List<Article> articles=articleDao.selectArticleByClassification(classification);
//        System.out.println(articles.get(1).getUptime());
        String jsonObjects=gson.toJson(articles);
        out.write(jsonObjects);
    }
}
