package com.example.springbootdemo.dao;

import com.example.springbootdemo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户映射接口(@Repository注解是把这个接口的一个实现类交给spring管理)
 */
@Repository
public interface UserDao {
    /**
     * 查找所有用户列表
     *
     * @return
     */
    List<User> getUserList();

    /**
     * 通过id查找用户
     *
     * @param id
     * @return
     */
    User getUserById(int id);

    /**
     * 通过用户名查询用户列表
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
    void updateUser(User user);

    /**
     * 删除用户信息
     * @param id
     */
    void delete(int id);
}