package com.pro.customer.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pro.customer.common.ComFunction;
import com.pro.customer.common.JsonResult;
import com.pro.customer.common.ResultMsg;
import com.pro.customer.dao.SysUserMapper;
import com.pro.customer.entity.SysUser;
import com.pro.customer.service.LakeSysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


/**
 * 用户管理信息
 *
 * @author LiChun
 */
@Service
public class LakeSysUserServiceImpl implements LakeSysUserService {
    private static Logger logger = LoggerFactory.getLogger(LakeSysUserServiceImpl.class);

    @Autowired
    private SysUserMapper sysUserMapper;



    @Override
    public JsonResult queryAllUser() {
        JsonResult jr= new JsonResult();
        List<SysUser> lsu=new ArrayList<>();
        String errorMsg="";
        try {
            lsu=sysUserMapper.findAll();
            if (lsu.size()==0){
                errorMsg=errorMsg+ ResultMsg.NOGET;
                jr.setMsgInfo(ResultMsg.NOGET);
            }
        }catch (Exception e){
            logger.error(ResultMsg.SQLERROR+e.getMessage());
            errorMsg=errorMsg+ResultMsg.SQLERROR;
        }
        jr= ComFunction.resultMsg(errorMsg,lsu);
        return jr;
    }

    /**
     * 生成登录校验信息
     * @param sysUser
     * @return
     */
    @Override
    public JsonResult getLoginKey(SysUser sysUser) {
        SysUser su=sysUserMapper.findByUser(sysUser);
        JsonResult jr;
        SimpleDateFormat df= new SimpleDateFormat((new Date()).toString());
        String resutltKey="";
        String errorMsg="";
        try {
            if(!"".equals(su.getUserName())){
                resutltKey=df.format(new Date())+ ComFunction.getRandSixString();
            }else{
                logger.error(ResultMsg.NOGET);
                errorMsg=errorMsg+ResultMsg.NOGET;
            }
        }catch (Exception e){
            logger.error(ResultMsg.SQLERROR+e.getMessage());
            errorMsg=errorMsg+ResultMsg.SQLERROR;
        }
        jr= ComFunction.resultMsg(errorMsg,resutltKey);
        return jr;
    }

    /**
     * 查询单个用户信息
     * @param sysUser
     * @return
     */
    @Override
    public JsonResult queryOneUser(SysUser sysUser) {

        JsonResult jr;
        SysUser sysUserRest=new SysUser();
        String errorMsg="";
        try {
            sysUserRest= sysUserMapper.findByUser(sysUser);
            if (sysUserRest.getUserId()==null){
                errorMsg=errorMsg+ResultMsg.NOGET;
            }
        }catch (Exception e){
            logger.error(ResultMsg.SQLERROR+e.getMessage());
            errorMsg=errorMsg+ResultMsg.SQLERROR;
        }
        jr= ComFunction.resultMsg(errorMsg,sysUserRest);
        return jr;
    }

    @Override
    public JsonResult queryListUser(SysUser sysUser) {
        JsonResult jr;
        List<SysUser> sysUserRest =new ArrayList<>();
        String errorMsg="";
        try {
            sysUserRest=sysUserMapper.findListUser(sysUser);
            if (sysUserRest.size()==0){
                errorMsg=errorMsg+ResultMsg.NOGET;
            }
        }catch (Exception e){
            logger.error(ResultMsg.SQLERROR+e.getMessage());
            errorMsg=errorMsg+ResultMsg.SQLERROR;
        }
        jr= ComFunction.resultMsg(errorMsg,sysUserRest);
        return jr;
    }

    @Override
    public JsonResult delOneUser(Integer userId){
        JsonResult jr;
        int result=0;
        String errorMsg="";
        try {
            result =sysUserMapper.deleteByPrimaryKey(userId);
            errorMsg=ResultMsg.resultIDUErrorMsg(result,errorMsg);
        }catch (Exception e){
            logger.error(ResultMsg.SQLERROR+e.getMessage());
            errorMsg=errorMsg+ResultMsg.SQLERROR;
        }
        jr= ComFunction.resultMsg(errorMsg,result);
        return jr;
    }

    @Override
    public JsonResult updateOneUser(SysUser sysUser) {
        JsonResult jr;
        int result=0;
        String errorMsg="";
        try {
            result=sysUserMapper.updateByPrimaryKey(sysUser);
            errorMsg=ResultMsg.resultIDUErrorMsg(result,errorMsg);
        }catch (Exception e){
            logger.error(ResultMsg.SQLERROR+e.getMessage());
            errorMsg=errorMsg+ResultMsg.SQLERROR;
        }
        jr= ComFunction.resultMsg(errorMsg,result);
        return jr;
    }

    /**
     * 新增单个用户
     * @param sysUser
     * @return
     */
    @Override
    public JsonResult addOneUser(SysUser sysUser) {
        JsonResult jr;
        int result=0;
        String errorMsg="";
        try {
            result=sysUserMapper.addUser(sysUser);
            errorMsg=ResultMsg.resultIDUErrorMsg(result,errorMsg);
        }catch (Exception e){
            logger.error(ResultMsg.SQLERROR+e.getMessage());
            errorMsg=errorMsg+ResultMsg.SQLERROR;
        }
        jr= ComFunction.resultMsg(errorMsg,result);
        return jr;
    }

    @Override
    public JsonResult addAllUser(List<SysUser> sysUserList) {
        return null;
    }
}
