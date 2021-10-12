package com.example.ac.xuexi_https_wangluoqingqiu.http.bean;


import com.example.ac.xuexi_https_wangluoqingqiu.http.bean.base.BaseReqInfo;
import com.example.ac.xuexi_https_wangluoqingqiu.http.bean.base.Rapdu;

import java.util.List;


public class AppInstallApduReqInfo extends BaseReqInfo {

    /**
     * 用户号码
     */
    private String msisdn;
    /**
     * 任务标识（首次调用为空）
     */
    private String taskId;
    /**
     * 客户端类型（0：Android；1：ios）
     */
    private String clientType;

    /**
     * 卡片或设备唯一标识（iccid）
     */
    private String seid;
    /**
     * 应用AID
     */
    private String appletAID;

    /**操作类型*/
    private String operType;
    /**
     * 支付订单号
     */
    private String onLineTN;
    /**
     * capdu执行结果
     */
    private List<Rapdu> apdus;

    public String getOnLineTN() {
        return onLineTN;
    }

    public void setOnLineTN(String onLineTN) {
        this.onLineTN = onLineTN;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

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

    public String getOperType() {
        return operType;
    }

    public void setOperType(String operType) {
        this.operType = operType;
    }

    public List<Rapdu> getApdus() {
        return apdus;
    }

    public void setApdus(List<Rapdu> apdus) {
        this.apdus = apdus;
    }

    @Override
    public String toString() {
        return "AppInstallApduReqInfo{" +
                "msisdn='" + msisdn + '\'' +
                ", taskId='" + taskId + '\'' +
                ", clientType='" + clientType + '\'' +
                ", appletAID='" + appletAID + '\'' +
                ", onLineTN='" + onLineTN + '\'' +
                ", rapduList=" + apdus +
                '}';
    }
}
