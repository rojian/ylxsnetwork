package com.tosit.ylxs.dao;

import com.tosit.ylxs.entity.User;

/**
 * Created by Administrator on 2016/9/26.
 */
public interface ImplementUserDao {
    /**
     * 添加用户
     * @return 判断是否创建成功
     */
    public boolean addUser(User user);

    /**
     * 删除用户
     * @return 判断是否删除成功
     */
    public boolean delUser(User user);

    /**
     * 更改用户
     * @return 判断是否更改成功
     */
    public boolean upUser(User user);

    /**
     * 查询用户
     * @param user 是否存在该用户
     * @return
     */
    public boolean findUser(User user);



}
