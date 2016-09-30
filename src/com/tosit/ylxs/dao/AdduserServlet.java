package com.tosit.ylxs.dao;

import com.tosit.ylxs.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2016/9/30.
 */
@WebServlet("/addduserServlet")
public class AddUserServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out =resp.getWriter();
        String usernameadd=req.getParameter("usernameadd");
        String passwordadd=req.getParameter("passwordadd");
        String repasswordadd=req.getParameter("repasswordadd");
        if (usernameadd!=null&&passwordadd!=null&&repasswordadd!=null&&!usernameadd.equals("")&&!passwordadd.equals("")&&!repasswordadd.equals("")){
            if (passwordadd.equals(repasswordadd)){
                User user=new User(usernameadd,passwordadd);
                UserDao userDao =new UserDao();
                boolean isOk=userDao.addUser(user);
                if (isOk){
                    out.print("添加用户成功");
                }else {
                    out.print("添加用户失败");
                }
            }else {
                out.print("两次输入密码不等");
            }
        }else {
            out.print("输入值不能为空");
        }
    }
}
