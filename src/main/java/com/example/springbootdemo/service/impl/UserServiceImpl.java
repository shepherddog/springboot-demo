package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.dao.UserDao;
import com.example.springbootdemo.dto.ApiResult;
import com.example.springbootdemo.entity.User;
import com.example.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// 加入service，将实现交给spring来管理
@Service
public class UserServiceImpl implements UserService {
    // 加入dao的注入
    @Autowired
    private UserDao userDao;

    /**
     * 获取所有用户列表
     *
     * @return
     */
    @Override
    public List<User> getUserList() {
        return userDao.getUserList();
    }

    /**
     * 通过用户id查询用户信息
     *
     * @param id
     * @return
     */
    @Override
    public User getUser(int id) {
        return userDao.getUserById(id);
    }

    /**
     * 通过用户姓名查询用户信息
     *
     * @param userName
     * @return
     */
    @Override
    public List<User> getUserByUserName(String userName) {
        return userDao.getUserByUserName(userName);
    }

    /**
     * 添加新用户
     *
     * @param user
     */
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    /**
     * 添加新用户
     *
     * @param user
     */
    @Override
    public void updateUser(User user) throws Exception {
        if (null == user || "".equals(user.getUsername())) throw new Exception("用户信息不得为空");

        User userOriginal = userDao.getUserById(user.getId());
        if (null == userOriginal) throw new Exception("当前用户不存在");

        userOriginal.setAge(user.getAge());
        userOriginal.setSex(user.getSex());
        userOriginal.setUsername(user.getUsername());
        userOriginal.setPassword(user.getPassword());

        userDao.updateUser(userOriginal);
    }

    @Override
    public ApiResult delete(int id) {
        userDao.delete(id);

        ApiResult apiResult = new ApiResult();
        apiResult.setSuccess(true);
        apiResult.setCode("200");

        return apiResult;
    }
}