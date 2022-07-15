package com.example.springbootdemo.service;

import com.example.springbootdemo.dto.ApiResult;
import com.example.springbootdemo.entity.User;

import java.util.List;

public interface UserService {
    /**
     * 通过所有用户列表
     *
     * @return
     */
    List<User> getUserList();

    /**
     * 通过用户id查询用户信息
     *
     * @param id
     * @return
     */
    User getUser(int id);

    /**
     * 通过用户姓名查询用户信息
     *
     * @param userName
     * @return
     */
    List<User> getUserByUserName(String userName);

    /**
     * 添加新用户
     *
     * @param user
     */
    void addUser(User user);

    /**
     * 更新用户信息
     *
     * @param user
     */
    void updateUser(User user) throws Exception;

    /**
     * 删除用户信息
     *
     * @param id
     * @return
     */
    ApiResult delete(int id);
}