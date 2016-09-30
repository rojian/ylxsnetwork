package com.tosit.ylxs.dao;

import com.tosit.ylxs.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 实现ImplementUserDao里的方法
 * Created by Administrator on 2016/9/29.
 */
public class UserDao implements ImplementUserDao {
    public static final String URL = "jdbc:mysql://192.168.1.113:3306/ylxsnetword";
    public static final String USER = "root";
    public static final String PASSWORD = "root";
    @Override
    public boolean addUser(User user) {
        boolean isOk=true;
        Connection conn =null;
        try {
            conn= DriverManager.getConnection(URL,USER,PASSWORD);
            PreparedStatement pstm =conn.prepareStatement("insert into ylxsnetwork_user (username,password) values(?,?)");
            pstm.setString(1,user.getUsername());
            pstm.setString(2,user.getPassword());
            pstm.setString(1,user.getUsername());
            int i =  pstm.executeUpdate();
            if (i==0){
                isOk=false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isOk;
    }

    @Override
    public boolean delUser(User user) {
        boolean isOk=true;
        Connection conn =null;
        try {
            conn= DriverManager.getConnection(URL,USER,PASSWORD);
            PreparedStatement pstm =conn.prepareStatement("DELETE from ylxsnetwork_user where username=?");
            pstm.setString(1,user.getUsername());
            int i =  pstm.executeUpdate();
           if (i==0){
               isOk=false;
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isOk;
    }

    @Override
    public boolean upUser(User user) {
        boolean isOk=true;
        Connection conn =null;
        try {
            conn= DriverManager.getConnection(URL,USER,PASSWORD);
            PreparedStatement pstm =conn.prepareStatement("update ylxsnetwork_user set password=? where username=?");
            pstm.setString(1,user.getPassword());
            pstm.setString(2,user.getUsername());
            int i =  pstm.executeUpdate();
            if (i==0){
                isOk=false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isOk;
    }

    @Override
    public boolean findUserByName(User inuser) {
        boolean isOk=true;
        Connection conn =null;
        try {
            conn= DriverManager.getConnection(URL,USER,PASSWORD);
            PreparedStatement pstm =conn.prepareStatement("SELECT *from ylxsnetwork_user WHERE username=? and password=?");
            pstm.setString(1,inuser.getUsername());
            pstm.setString(2,inuser.getPassword());
            isOk=pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isOk;
    }

    @Override
    public List<User> findAllUser() {
        List<User> users=new ArrayList<>();
        Connection conn =null;
        try {
            conn= DriverManager.getConnection(URL,USER,PASSWORD);
            PreparedStatement pstm =conn.prepareStatement("SELECT *from ylxsnetwork_user");
            ResultSet resultSet =pstm.executeQuery();
            while (resultSet.next()){
                String username=resultSet.getString("username");
                String password =resultSet.getString("password");

                User user =new User(username,password);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  users;

    }


    public static void main(String[] args) {
        UserDao userDao =new UserDao();
        User user =new User("xiao","123");
        boolean isOk=userDao.upUser(user);

        System.out.println(isOk);
    }
}
