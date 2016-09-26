package com.tosit.ylxs.dao;

import com.tosit.ylxs.entity.Article;

import java.util.List;


/**
 * Created by Administrator on 2016/9/26.
 */
public interface  ImplementArticleDao {
    /**
     * 通过Id查询Article
     * @param id
     * @return 返回Article对象
     */
    public Article selectArticleById(int id);

    /**
     * 查询全部Article
     * @return Article对象集合
     */
    public List<Article>  selectArticleAll();
}
