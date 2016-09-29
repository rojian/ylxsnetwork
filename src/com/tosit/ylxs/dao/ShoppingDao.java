package com.tosit.ylxs.dao;

import com.sun.corba.se.pept.transport.Connection;
import com.tosit.ylxs.entity.Article;
import com.tosit.ylxs.entity.Shopping;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                String plateId = result.getString("plateId");
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

 public static void main(String[] args){
        ShoppingDao shoppingDao = new ShoppingDao();

      Shopping shopping = shoppingDao.selectShoppingById(1232333);
        System.out.println(shoppingDao);
    }
    }











