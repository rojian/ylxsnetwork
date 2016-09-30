package com.tosit.ylxs.dao;

import com.tosit.ylxs.entity.Shopping;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaoyixiangde on 2016/9/28.
 */
public class ShoppingDao implements ImplementShoppingDao {
    public static final String URL = "jdbc:mysql://192.168.1.113:3306/ylxsnetword";
    public static final String USER = "root";
    public static final String PASSWORD = "root";

    @Override
    public Shopping selectShoppingById(int inid) {
        Shopping shopping = new Shopping();
        java.sql.Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement pstm = conn.prepareStatement("select*from ylxsnetwork_shopping where id=?");
            pstm.setInt(1, inid);
            ResultSet result = pstm.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String plateId = result.getString("name");
                String price = result.getString("price");
                String address = result.getString("address");
                String story = result.getString("story");

                shopping.setId(id);
                shopping.setPlateId(plateId);
                shopping.setAddress(address);
                shopping.setPrice(price);
                shopping.setStory(story);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shopping;
    }

    public List<Shopping> selectShoppingAllshop() {
        List<Shopping> shoppingList = new ArrayList<>();
        java.sql.Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement pstm = conn.prepareStatement("select*from ylxsnetwork_shopping");

            ResultSet result = pstm.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String plateId = result.getString("name");
                String price = result.getString("price");
                String address = result.getString("address");
                String story = result.getString("story");
                Shopping shopping = new Shopping();
                shopping.setId(id);
                shopping.setPlateId(plateId);
                shopping.setAddress(address);
                shopping.setPrice(price);
                shopping.setStory(story);
                shoppingList.add(shopping);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return shoppingList;
    }

    @Override
    public boolean addShopping(Shopping shopping) {
        boolean isOk=false;
        Connection conn =null;
        try {
            conn= DriverManager.getConnection(URL,USER,PASSWORD);
//            PreparedStatement pstm =conn.prepareStatement("insert into ylxsnetwork_user (username,password) values(?,?)");
//            pstm.setString(1,shopping.getUsername());
//            pstm.setString(2,shopping.getPassword());
//            pstm.setString(1,shopping.getUsername());
//            int i =  pstm.executeUpdate();
//            if (i==0){
//                isOk=false;
//            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isOk;
//        return  isOk;
    }

    public static void main(String[] args){
        ShoppingDao shoppingDao = new ShoppingDao();
        List<Shopping> shopping = shoppingDao.selectShoppingAllshop();
        shopping.get(1).getPrice();
        System.out.println(shopping);
    }
    }











