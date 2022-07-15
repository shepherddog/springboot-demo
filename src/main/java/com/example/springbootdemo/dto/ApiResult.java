package com.example.springbootdemo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "服务执行结果", description = "服务执行结果")
public class ApiResult {
    @ApiModelProperty("是否执行成功")
    private boolean isSuccess;
    @ApiModelProperty("执行结果编码")
    private String code;
    @ApiModelProperty("错误信息")
    private String message;
}