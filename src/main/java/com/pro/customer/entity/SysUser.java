/*
 * *******************************************************************************************
 * Copyright (c) 2020. wshh
 * Company :Shanghai pactera jinxin software co., LTD
 * Address:Room 607, building 4, 299 longcao road, xuhui district, Shanghai
 * *******************************************************************************************
 */

package com.pro.customer.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 用户信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "用户信息")
public class SysUser {
    @ApiModelProperty(value = "自增长ID（不需录）")
    private Integer userId;
    @ApiModelProperty(value = "用户名（必录）")
    private String userName="";
    @ApiModelProperty(value = "用户中文名（非必录）")
    private String userCnName="";
    @ApiModelProperty(value = "密码（必录）")
    private String userPassword="";
    @ApiModelProperty(value = "电子邮件地址（非必录）")
    private String emailAddr="";
    @ApiModelProperty(value = "电话号码（非必录）")
    private String telephoneNum="";
    @ApiModelProperty(value = "移动电话号码（非必录）")
    private String mobileNum="";
    @ApiModelProperty(value = "用户排序（非必录）")
    private String userDesc="";
    @ApiModelProperty(value = "用户状态（非必录）")
    private Integer userStatus;
    @ApiModelProperty(value = "创建信息（非必录）")
    private String createrInfo="";
    @ApiModelProperty(value = "最后修改人（非必录）")
    private String lastModifier="";
    @ApiModelProperty(value = "创建时间（非必录）")
    private Date createTime;
    @ApiModelProperty(value = "更新时间（非必录）")
    private Date updateTime;
    @ApiModelProperty(value = "是否删除（非必录）")
    private Integer isDelete;

}
