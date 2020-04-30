package com.pro.customer.common;

/**
 * 返回结果
 */
public class JsonResult {

    /**
     * 返回结果
     */
    private String status = "";

    /**
     * 返回内容
     */
    private Object result = null;
    /**
     * 返回信息
     */
    private String msgInfo="";

    /**
     * @return String
     */
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String getMsgInfo() {
        return msgInfo;
    }

    public void setMsgInfo(String msgInfo) {
        this.msgInfo = msgInfo;
    }
}
