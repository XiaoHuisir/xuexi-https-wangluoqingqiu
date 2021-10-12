package com.example.ac.xuexi_https_wangluoqingqiu.http.bean;

public class AppDeleteReqInfo {

    /**
     * 客户类型
     * 0：Android
     * 1：ios
     */
    private String clientType;

    /**
     * 卡片或设备唯一标识（iccid）
     */
    private String seid;

    /**
     * 开卡时对应AID
     */
    private String appletAID;

    /**
     * 开卡订单号
     */
    private String orderNum;


    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getSeid() {
        return seid;
    }

    public void setSeid(String seid) {
        this.seid = seid;
    }

    public String getAppletAID() {
        return appletAID;
    }

    public void setAppletAID(String appletAID) {
        this.appletAID = appletAID;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }
}
