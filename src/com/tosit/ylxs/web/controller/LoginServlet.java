package com.tosit.ylxs.web.controller;

import com.tosit.ylxs.dao.UserDao;
import com.tosit.ylxs.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2016/9/30.
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        User user=new User(username,password);
        UserDao userDao =new UserDao();
        boolean isOk=userDao.findUserByName(user);
        System.out.println(username+":"+password);
        if (isOk){
            req.getSession().setAttribute("user",user);
            resp.sendRedirect("main.html");
        }

    }
}
