/*
 * *******************************************************************************************
 * Copyright (c) 2020. wshh
 * Company :Shanghai pactera jinxin software co., LTD
 * Address:Room 607, building 4, 299 longcao road, xuhui district, Shanghai
 * *******************************************************************************************
 */

package com.pro.customer.controller;


import com.pro.customer.common.ComFunction;
import com.pro.customer.common.JsonResult;
import com.pro.customer.common.ResultMsg;
import com.pro.customer.entity.SysUser;
import com.pro.customer.service.LakeSysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 登录控制语言
 */
@Api(value="用户管理",description = "用户管理")
@Controller
@RequestMapping("/api/userController")
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);


    // 创建线程安全的Map
    //static Map<Integer, User> users = Collections.synchronizedMap(new HashMap<Integer, User>());

    @Autowired
    private LakeSysUserService lakeSysUserService;
    /**
     * 查询所有用户信息
     * @return
     */
    @ApiOperation(value="查询所有用户信息", notes="查询所有用户信息")
    @GetMapping(value = "user/getAllUser")
    public ResponseEntity<JsonResult> getAllUser (){
        JsonResult jr = new JsonResult();
        String errorMsg="";
        if(true){
            jr=lakeSysUserService.queryAllUser();
            jr.setResult(jr.getResult());
            jr.setMsgInfo(jr.getMsgInfo());
        }else {
            jr.setStatus(ResultMsg.ERROR);
            errorMsg=errorMsg+ResultMsg.LOGTIMEOUT;
        }
        jr= ComFunction.resultMsg(jr.getMsgInfo()+errorMsg,jr.getResult());
        return ResponseEntity.ok(jr);
    }

    /**
     * 获取登录信息
     * @param sysUser
     * @return ResponseEntity<JsonResult>
     */
    @ApiOperation(value="根据用户信息获取验证校验代码", notes="根据用户信息获取验证校验代码")
    @PostMapping(value = "user/getLoginKey")
    public ResponseEntity<JsonResult> getLoginKey(SysUser sysUser){
        JsonResult jr= new JsonResult();
        String errorMsg="";
        SysUser sysUser1=new SysUser();
        //检验用户信息
        if(!"".equals(sysUser.getUserName()) && !"".equals(sysUser.getUserPassword())){
            jr=lakeSysUserService.getLoginKey(sysUser);
            sysUser1=(SysUser)lakeSysUserService.queryOneUser(sysUser).getResult();
        }else{
            errorMsg=errorMsg+"用户名密码不能为空";
        }

        jr=ComFunction.resultMsg(jr.getMsgInfo()+errorMsg,jr.getResult());
        return  ResponseEntity.ok(jr);
    }

    @ApiOperation(value="单个用户详细信息查询", notes="单个用户详细信息查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "resultKey", value = "校验信息", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "userName", value = "用户名", required = true, dataType = "String", paramType = "path")
    })
    @GetMapping(value = "user/getOneUser/{userName}")
    public ResponseEntity<JsonResult> getOneUser( @PathVariable String userName ){
        JsonResult jr=new JsonResult();
        SysUser su= new SysUser();
        String errorMsg="";
        su.setUserName(userName);
        if(true){
            try {
                jr=lakeSysUserService.queryOneUser(su);
            }catch (Exception e){
                logger.error(ResultMsg.NOGET+e.getMessage());
                errorMsg=errorMsg+ResultMsg.NOGET;
            }
        }else {
            errorMsg=errorMsg+ResultMsg.LOGTIMEOUT;
            jr.setResult("");

        }
        jr =ComFunction.resultMsg(errorMsg+jr.getMsgInfo(),jr.getResult());
        return ResponseEntity.ok(jr);
    }

    /**
     * 用户信息模糊查询
     * @return ResponseEntity<JsonResult>
     */
    @ApiOperation(value="用户条件模糊查询", notes="用户条件模糊查询")
    @GetMapping(value = "user/getListUser")
    public ResponseEntity<JsonResult> getUserList(SysUser sysUser){
        JsonResult jr=new JsonResult();
        String errorMsg="";
        if(true){
            try {
                jr=lakeSysUserService.queryListUser(sysUser);
            }catch (Exception e){
                logger.error(ResultMsg.NOGET);
                errorMsg=errorMsg+ResultMsg.NOGET;
            }
        }else {
            errorMsg=errorMsg+ResultMsg.LOGTIMEOUT;
            jr.setResult("");
        }
        jr =ComFunction.resultMsg(jr.getMsgInfo()+errorMsg,jr.getResult());
        return ResponseEntity.ok(jr);
    }

    /**
     * 新增用户
     * @param sysUser
     * @return
     */
    @ApiOperation(value="新增单个用户", notes="新增单个用户")
    @PostMapping(value = "user/addUserOne")
    public ResponseEntity<JsonResult> addUserOne(@RequestBody SysUser sysUser){
        JsonResult jr= new JsonResult();
        String errorMsg="";
        if(true){
            if("".equals(sysUser.getUserName()) && "".equals(sysUser.getUserPassword())){
                errorMsg=errorMsg+" 用户名密码不为空 ";
                logger.error("用户名密码不为空");
            }else{
                jr =lakeSysUserService.addOneUser(sysUser);
            }
        }else {
            errorMsg=errorMsg+ResultMsg.LOGTIMEOUT;
            jr.setResult("");
        }
        jr =ComFunction.resultMsg(jr.getMsgInfo()+errorMsg,jr.getResult());
        return ResponseEntity.ok(jr);
    }

    /**
     * 删除单个用户
     * @param userId
     * @return
     */
    @ApiOperation(value="删除单个用户", notes="删除单个用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "删除的用户编号", required = true, dataType = "Integer", paramType = "path")
    })
    @DeleteMapping(value = "user/delUserOne/{userId}")
    public ResponseEntity<JsonResult> delUserOne( @PathVariable Integer userId){
        JsonResult jr= new JsonResult();
        String errorMsg="";
        if(true){
            jr=lakeSysUserService.delOneUser(userId);
        }else {
            errorMsg=errorMsg+ResultMsg.LOGTIMEOUT;
            jr.setResult("");
        }
        jr =ComFunction.resultMsg(jr.getMsgInfo()+errorMsg,jr.getResult());
        return ResponseEntity.ok(jr);
    }

    /**
     * 更新单个用户
     * @param sysUser
     * @return
     */
    @ApiOperation(value="更新单个用户", notes="更新单个用户")
    @PostMapping(value = "user/updateUserOne")
    public ResponseEntity<JsonResult> updateUserOne(@RequestBody SysUser sysUser){
        JsonResult jr=new JsonResult();
        String errorMsg="";
        if(true){
            try {
                jr=lakeSysUserService.updateOneUser(sysUser);
            }catch (Exception e){
                logger.error(ResultMsg.NOGET);
                errorMsg=errorMsg+ResultMsg.NOGET;
            }
        }else {
            errorMsg=errorMsg+ResultMsg.LOGTIMEOUT;
            jr.setResult("");
        }
        jr =ComFunction.resultMsg(jr.getMsgInfo()+errorMsg,jr.getResult());
        return ResponseEntity.ok(jr);
    }

    @ApiOperation(value="测试", notes="测试")
    @PostMapping(value = "user/testController")
    public ResponseEntity<JsonResult> testController(){
        JsonResult jr=new JsonResult();
        jr.setResult("测试成功");
        jr.setStatus(ResultMsg.SUCCESS);
        return ResponseEntity.ok(jr);
    }

}