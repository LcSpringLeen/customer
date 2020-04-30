/*
 * *******************************************************************************************
 * Copyright (c) 2020. wshh
 * Company :Shanghai pactera jinxin software co., LTD
 * Address:Room 607, building 4, 299 longcao road, xuhui district, Shanghai
 * *******************************************************************************************
 */

package com.pro.customer.common;


import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 公共方法
 */
public class ComFunction {
    /**
     * 获取6位随机数(纯数字)
     * @return
     */
    public static String getRandSixString(){
        Double mrd=Math.random();
        return mrd.toString().substring(3,9);
    }

    /**
     * 根据map的key排序
     *
     * @param map 待排序的map
     * @param isDesc 是否降序，true：降序，false：升序
     * @return 排序好的map
     * @author zero 2019/04/08
     */
    public static <K extends Comparable<? super K>, V> Map<K, V> sortByKey(Map<K, V> map, boolean isDesc) {
        Map<K, V> result = Maps.newLinkedHashMap();
        if (isDesc) {
            map.entrySet().stream().sorted(Map.Entry.<K, V>comparingByKey().reversed())
                    .forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
        } else {
            map.entrySet().stream().sorted(Map.Entry.<K, V>comparingByKey())
                    .forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
        }
        return result;
    }

    /**
     * 根据map的value排序
     *
     * @param map 待排序的map
     * @param isDesc 是否降序，true：降序，false：升序
     * @return 排序好的map
     * @author zero 2019/04/08
     */
    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map, boolean isDesc) {
        Map<K, V> result = Maps.newLinkedHashMap();
        if (isDesc) {
            map.entrySet().stream().sorted(Map.Entry.<K, V>comparingByValue().reversed())
                    .forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
        } else {
            map.entrySet().stream().sorted(Map.Entry.<K, V>comparingByValue())
                    .forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
        }
        return result;
    }

    /**
     * JsonResult 通用返回返回信息
     * @param errorMsg 不为空则认为有错误
     * @param result 返回信息
     * @return
     */
    public static JsonResult resultMsg(String errorMsg,Object result){
        JsonResult jr= new JsonResult();
        if(!"".equals(errorMsg)){
            jr.setStatus(ResultMsg.ERROR);
            jr.setMsgInfo(errorMsg);
        }else{
            jr.setStatus(ResultMsg.SUCCESS);
            jr.setResult(result);
        }
        return jr;
    }

    /**
     *  校验权限
     * @param allPower 所有允许的权限
     * @param checkPower 需要检查的权限
     * @return boolean
     */
    public static boolean checkMathPower(String allPower,String checkPower){
        String allPowerList[]=allPower.split(",");
        for (String stringTmp:allPowerList) {
            if(checkPower.equals(stringTmp)){
                return true;
            }
        }
        return false;
    }






    public static void main(String[] args) {
        Map<String, Integer> map = ImmutableMap.of("0", 3, "1", 8, "0.29", 7, "1.67", 3);
        System.out.println("原始的map：" + map);
        System.out.println("根据map的key降序：" + sortByKey(map, true));
        System.out.println("根据map的key升序：" + sortByKey(map, false));
        System.out.println("根据map的value降序：" + sortByValue(map, true));
        System.out.println("根据map的value升序：" + sortByValue(map, false));

        System.out.println(checkMathPower("enabled,download,upload,delete,update,insert,select,query",""));

    }






}
