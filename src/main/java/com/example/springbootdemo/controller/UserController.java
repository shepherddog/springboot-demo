package com.example.springbootdemo.controller;

import com.example.springbootdemo.dto.ApiResult;
import com.example.springbootdemo.dto.UserRequestDto;
import com.example.springbootdemo.entity.User;
import com.example.springbootdemo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 在接口类上添加@Api(tags = "操作接口")，tags的值是该类的作用，在文档页面会显示，value不会显示
 * 在需要生成文档的接口上添加注解@ApiOperation
 * 对请求参数添加@ApiParam
 */
@Api(tags = "用户控制器")
@RestController
@RequestMapping("user")
public class UserController {
    // 接口服务注入
    @Autowired
    private UserService userService;

    @ApiOperation("查找所有用户列表")
    @GetMapping(value = {"/getUserList"})
    public List<User> getUserList() {
        return userService.getUserList();
    }

    @ApiOperation("通过用户Id查找用户信息")
    @GetMapping(value = {"/getUser"})
    public User getUser(@ApiParam(name = "id", value = "用户Id") int id) {
        return userService.getUser(id);
    }

    @ApiOperation("通过用户姓名查询用户列表")
    @GetMapping("/getUserByUserName")
    public List<User> getUserByUserName(@ApiParam(name = "userName", value = "用户姓名") String userName) {
        return userService.getUserByUserName(userName);
    }

    @ApiOperation("添加用户信息")
    @PostMapping("/addUser")
    public String Add(@ApiParam(name = "user", value = "用户信息") UserRequestDto user) throws Exception {
        try {
            // 先判断用户名存在不存在如果存在，则报错，否则添加
            if (null == user || "".equals(user.getUsername())) {
                return "用户或用户信息不得为空";
            }
            List<User> users = userService.getUserByUserName(user.getUsername());
            if (null != users && users.size() > 0) {
                return "用户名已存在";
            }
            User userItem = new User();
            userItem.setUsername(user.getUsername());
            userItem.setPassword(user.getPassword());
            userItem.setAge(user.getAge());
            userItem.setSex(user.getSex());
            userService.addUser(userItem);
            return "用户" + user.getUsername() + "添加成功";
        } catch (Exception ex) {
            return "异常信息:" + ex.getMessage();
        }
    }

    @ApiOperation("更新用户信息")
    @PutMapping("/updateUser")
    public String Update(@ApiParam(name = "user", value = "用户信息") User user) throws Exception {
        try {
            if (null == user || "".equals(user.getUsername()) || 0 == user.getId()) {
                return "用户或用户信息不得为空";
            }
            if ("".equals(user.getPassword()) || user.getPassword().length() < 5) {
                return "用户密码至少为5位";
            }
            User userItem = userService.getUser(user.getId());
            if (null == userItem) {
                return "用户不存在，无法更新，请先添加";
            }

            userService.updateUser(user);
            return "用户" + user.getUsername() + "信息更新成功";
        } catch (Exception ex) {
            return "异常信息:" + ex.getMessage();
        }
    }

    @ApiOperation("删除用户信息")
    @DeleteMapping("/delete")
    public ApiResult delete(@ApiParam(name = "id", value = "用户Id") @RequestParam(value = "id") int id) {
        ApiResult result = new ApiResult();
        if (id <= 0) {
            result.setCode("-1");
            result.setMessage("非法id");
            return result;
        }
        return userService.delete(id);
    }
}