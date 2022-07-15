package com.example.springbootdemo.service;

public interface StatusCode {
    /**
     * 获取错误码
     *
     * @param id
     * @return
     */
    public int getCode();
    public String getMsg();
}
