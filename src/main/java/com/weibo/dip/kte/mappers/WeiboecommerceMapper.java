package com.weibo.dip.kte.mappers;

/**
 * Created by fpschina on 16/2/24.
 */
public class WeiboecommerceMapper {
    private String dataType;        //类型
    private String timeStamp;       //时间戳
    private String cTime;           //时间
    private String clientIP;        //IP1
    private String serverIP;        //IP1
    private String requestID;       //调用链
    private String requestURL;      //接口地址
    private String responseTime;    //执行时间
    private String code;            //相应码
    private String msg;             //相应描述
    private String dataLen;         //返回数据长度
    private String dataVal;         //返回数据


    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dateType) {
        this.dataType = dateType;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getcTime() {
        return cTime;
    }

    public void setcTime(String cTime) {
        this.cTime = cTime;
    }

    public String getClientIP() {
        return clientIP;
    }

    public void setClientIP(String clientIP) {
        this.clientIP = clientIP;
    }

    public String getServerIP() {
        return serverIP;
    }

    public void setServerIP(String serverIP) {
        this.serverIP = serverIP;
    }

    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    public String getRequestURL() {
        return requestURL;
    }

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public String getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(String responseTime) {
        this.responseTime = responseTime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDataLen() {
        return dataLen;
    }

    public void setDataLen(String dataLen) {
        this.dataLen = dataLen;
    }

    public String getDataVal() {
        return dataVal;
    }

    public void setDataVal(String dataVal) {
        this.dataVal = dataVal;
    }
}
