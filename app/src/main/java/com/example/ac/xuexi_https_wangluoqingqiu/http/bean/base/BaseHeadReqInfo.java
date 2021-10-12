package com.example.ac.xuexi_https_wangluoqingqiu.http.bean.base;

/**
 * Created by zhangfuxiao on 2017/8/21.
 */

public class BaseHeadReqInfo<T> {
    /**
     * clientType : 客户端，0 代表 Android，1 代表 iOS
     */
    private int clientType;
    /**
     * 手机系统版本
     */
    private String sysOperation;
    /**
     * 手机品牌-型号
     */
    private String mobilePhoneModel;
    /**
     * app包名
     */
    private String packageName;
    /**
     * app签名hash
     */
    private String hash;

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getSpid() {
        return spid;
    }

    public void setSpid(String spid) {
        this.spid = spid;
    }

    public String getSeid() {
        return seid;
    }

    public void setSeid(String seid) {
        this.seid = seid;
    }

    /**
     * 分配的厂商id
     */
    private String spid;
    /**
     * seid 或 iccid,卡片唯一标示
     */
    private String seid;
    /**
     * 上送的参数
     */
    private T data;

    public int getClientType() {
        return clientType;
    }

    public void setClientType(int clientType) {
        this.clientType = clientType;
    }

    public String getSysOperation() {
        return sysOperation;
    }

    public void setSysOperation(String sysOperation) {
        this.sysOperation = sysOperation;
    }

    public String getMobilePhoneModel() {
        return mobilePhoneModel;
    }

    public void setMobilePhoneModel(String mobilePhoneModel) {
        this.mobilePhoneModel = mobilePhoneModel;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseHeadReqInfo{" +
                "clientType=" + clientType +
                ", sysOperation='" + sysOperation + '\'' +
                ", mobilePhoneModel='" + mobilePhoneModel + '\'' +
                ", packageName='" + packageName + '\'' +
                ", hash='" + hash + '\'' +
                ", spid='" + spid + '\'' +
                ", seid='" + seid + '\'' +
                ", data=" + data.toString() +
                '}';
    }
}