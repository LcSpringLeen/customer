/*
 * *******************************************************************************************
 * Copyright (c) 2020. wshh
 * Company :Shanghai pactera jinxin software co., LTD
 * Address:Room 607, building 4, 299 longcao road, xuhui district, Shanghai
 * *******************************************************************************************
 */

package com.pro.customer.dao;

import com.pro.customer.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 系统用户信息
 */
@Mapper
public interface SysUserMapper {
    /**
     * 查找所有用户
     *
     * @return List<SysUser>
     */
    List<SysUser> findAll();

    /**
     * 通过用户信息查找用户完整信息
     *
     * @param sysUser SysUser
     * @return SysUser
     */
    SysUser findByUser(SysUser sysUser);

    /**
     * 新增用户
     *
     * @param sysUser SysUser
     * @return int
     */
    int addUser(SysUser sysUser);

    /**
     * 条件查找多个用户
     * @param sysUser SysUserSysUser
     * @return List<SysUser>
     */
    List<SysUser> findListUser(SysUser sysUser);

    /**
     * 通过主键删除用户信息
     * @param userId user_id
     * @return int
     */
    int deleteByPrimaryKey(Integer userId);

    /**
     * 插入用户信息（单条）
     * @param record SysUser
     * @return int
     */
    int insert(SysUser record);

    /**
     * 插入用户数据根据内容插入
     * @param record SysUser
     * @return int
     */
    int insertSelective(SysUser record);

    /**
     * 通过用户ID查找用户
     * @param userId user_id
     * @return SysUser
     */
    SysUser selectByPrimaryKey(Integer userId);

    /**
     * 通过传入参数修改用户信息
     * @param record SysUser
     * @return int
     */
    int updateByPrimaryKeySelective(SysUser record);

    /**
     * 完整插入用户信息
     * @param record SysUser
     * @return int
     */
    int updateByPrimaryKey(SysUser record);
}