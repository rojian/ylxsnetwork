package com.tosit.ylxs.dao;

import com.tosit.ylxs.entity.Shopping;

import java.util.List;

/**
 * Created by gaoyixiangde on 2016/9/28.
 */
public interface ImplementShoppingDao {


    public Shopping selectShoppingById(int id);

    /**
     * 通过板块plate查询Article
     *
     * @return Article对象集合
     */
public List<Shopping> selectShoppingAllshop();

    /**
     * 添加商品
     * @param shopping
     * @return
     */
    public boolean addShopping(Shopping shopping);
}
