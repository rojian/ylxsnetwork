package com.tosit.ylxs.dao;

import com.tosit.ylxs.entity.Article;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 对数据库article表进行操作
 * Created by Administrator on 2016/9/27.
 */
public class ArticleDao implements ImplementArticleDao {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static final String URL = "jdbc:mysql://192.168.1.119:3306/ylxsnetword";
    public static final String USER = "root";
    public static final String PASSWORD = "root";

    @Override
    public Article selectArticleById(int inid) {
        Article article = new Article();
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            PreparedStatement pstm = conn.prepareStatement("select*from ylxsnetwork_article where id=?");
            pstm.setInt(1, inid);
            ResultSet result = pstm.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String title = result.getString("title");
                String brief = result.getString("brief");
                String content = result.getString("content");
                String path = result.getString("path");
                String uptime = result.getDate("uptime").toString();

                article.setId(id);
                article.setTitle(title);
                article.setBrief(brief);
                article.setContent(content);
                article.setPath(path);
                article.setUptime(uptime);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return article;
    }

    @Override
    public List<Article> selectArticleByPlate(String inplate) {
        List<Article> articles = new ArrayList<>();
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            PreparedStatement pstm = conn.prepareStatement("select*from ylxsnetwork_article a  inner join ylxsnetwork_plate p on p.plateId=a.plateId where  p.plate=?");
            pstm.setString(1, inplate);
            ResultSet result = pstm.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String title = result.getString("title");
                String brief = result.getString("brief");
                String content = result.getString("content");
                String path = result.getString("path");
                String uptime = result.getDate("uptime").toString();
                Article article = new Article();
                article.setId(id);
                article.setTitle(title);
                article.setBrief(brief);
                article.setContent(content);
                article.setPath(path);
                article.setUptime(uptime);
                articles.add(article);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return articles;
    }

    public static void main(String[] args) {
        ArticleDao articleDao = new ArticleDao();
        List<Article> articles = articleDao.selectArticleByPlate("景区新闻");
        System.out.println(articles.get(1).getUptime());

    }
}
