/*
 * *******************************************************************************************
 * Copyright (c) 2020. wshh
 * Company :Shanghai pactera jinxin software co., LTD
 * Address:Room 607, building 4, 299 longcao road, xuhui district, Shanghai
 * *******************************************************************************************
 */
package com.pro.customer.common;

/**
 * 返回值定义
 */
public class ResultMsg {
    public static String ERROR="ERROR";
    public static String SUCCESS="SUCCESS";
    public static String NOGET="未查到结果";
    public static String SQLERROR="查询执行失败";
    public static String LOGTIMEOUT="登录超时";
    public static String ERRORGET="获取数据失败";
    public static String INSERTERROR="插入失败";
    public static String DELERROR="删除失败";
    public static String UPDATEERROR="更新失败";

    /**
     * 增删改统一返回方法
     * @param integer
     * @param result
     * @return
     */
    public static JsonResult resultInsertDeleteUpdate(Integer integer, Object result){
        JsonResult jr=new JsonResult();
        if (integer!=0){
            jr.setStatus(ResultMsg.SUCCESS);
            jr.setResult(result);
        }else{
            jr.setMsgInfo(ResultMsg.ERROR);
            jr.setMsgInfo(ResultMsg.NOGET);
        }
        return jr;
    }

    /**
     * 判断Insert Delete Update 操作是否成功
     * @param result
     * @param errorMsg
     * @return
     */
    public static String resultIDUErrorMsg(Integer result,String errorMsg){
        if(result==0){
            errorMsg=errorMsg+ResultMsg.NOGET;
        }
        return  errorMsg;
    }
}
