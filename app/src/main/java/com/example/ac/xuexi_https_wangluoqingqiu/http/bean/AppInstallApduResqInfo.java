package com.example.ac.xuexi_https_wangluoqingqiu.http.bean;


import com.example.ac.xuexi_https_wangluoqingqiu.http.bean.base.BaseReqInfo;

import java.util.List;

public class AppInstallApduResqInfo extends BaseReqInfo {
    /**
     * 响应编码
     */
    private String code;
    /**
     * 响应描述
     */
    private String info;
    /**
     * 支付订单号（首次调用时返回）
     */
    private String onlineTN;
    /**
     * 用户号码
     */
    private String msisdn;
    /**
     * 任务标识
     */
    private String taskId;
    /**
     * 结束标志
     * 00：循环结束；
     * 01：循环未结束
     */
    private String finishFlag;
    /**
     * APDU结果上送
     * 01：需要上送所有rapdu
     * 02：需要上送最后一条rapdu
     */
    private String rapduRespFlag;



    /**
     * capdu执行结果
     */
    private List<Capdu> apdus;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getOnlineTN() {
        return onlineTN;
    }

    public void setOnlineTN(String onlineTN) {
        this.onlineTN = onlineTN;
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

    public String getFinishFlag() {
        return finishFlag;
    }

    public void setFinishFlag(String finishFlag) {
        this.finishFlag = finishFlag;
    }

    public String getRapduRespFlag() {
        return rapduRespFlag;
    }

    public void setRapduRespFlag(String rapduRespFlag) {
        this.rapduRespFlag = rapduRespFlag;
    }
    public List<Capdu> getApdus() {
        return apdus;
    }

    public void setApdus(List<Capdu> apdus) {
        this.apdus = apdus;
    }


    @Override
    public String toString() {
        return "AppInstallApduResqInfo{" +
                "code='" + code + '\'' +
                ", info='" + info + '\'' +
                ", onlineTN='" + onlineTN + '\'' +
                ", msisdn='" + msisdn + '\'' +
                ", taskId='" + taskId + '\'' +
                ", finishFlag='" + finishFlag + '\'' +
                ", rapduRespFlag='" + rapduRespFlag + '\'' +
                ", apdus=" + apdus +
                '}';
    }
}
