package com.pro.customer.service;

import com.pro.customer.common.JsonResult;
import com.pro.customer.entity.SysUser;

import java.util.List;


/**
 * 用户登录服务层
 *
 * @author LiChun
 */
public interface LakeSysUserService {


    /**
     * 查询所有用户
     *
     * @return
     */
    JsonResult queryAllUser();

    /**
     * 通过用户名密码查询并返回连接秘钥
     * @param sysUser
     * @return
     */
    JsonResult getLoginKey(SysUser sysUser);

    /**
     * 查询单个用户
     *
     * @return
     */
    JsonResult queryOneUser(SysUser sysUser);

    /**
     * 模糊条件查找多个用户信息
     * @param sysUser
     * @return
     */
    JsonResult queryListUser(SysUser sysUser);

    /**
     * 删除单个用户
     *
     * @param userId
     * @return
     */
    JsonResult delOneUser(Integer userId);

    /**
     * 更新用户
     *
     * @param sysUser
     * @return
     */
    JsonResult updateOneUser(SysUser sysUser);

    /**
     * 新增用户
     *
     * @param sysUser
     * @return
     */
    JsonResult addOneUser(SysUser sysUser);

    /**
     * 新增多个用户
     *
     * @param sysUserList
     * @return
     */
    JsonResult addAllUser(List<SysUser> sysUserList);

}

