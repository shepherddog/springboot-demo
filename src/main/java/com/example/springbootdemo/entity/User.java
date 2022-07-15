package com.example.springbootdemo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "User", description = "用户信息")
public class User {
    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private int id;
    /**
     * 用户姓名
     */
    @ApiModelProperty("用户姓名")
    private String username;
    /**
     * 用户密码
     */
    @ApiModelProperty("用户密码")
    private String password;
    /**
     * 年龄
     */
    @ApiModelProperty("年龄")
    private int age;
    /**
     * 性别
     */
    @ApiModelProperty("性别")
    private String sex;
}