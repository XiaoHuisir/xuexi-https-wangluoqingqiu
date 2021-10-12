package com.example.ac.xuexi_https_wangluoqingqiu.http.bean;

public class CardStatusResqInfo {
    /**
     * 响应编码
     */
    private String code;
    /**
     * 响应描述
     */
    private String info;
    /**
     * 开状态
     * 0：无数据
     * 1：未开卡
     * 2：开卡中
     * 3：开卡成功
     * 4：开卡失败
     */
    private String status;
    /**
     * 羊城通逻辑卡号
     */
    private String cardNo;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    @Override
    public String toString() {
        return "CardStatusResqInfo{" +
                "code='" + code + '\'' +
                ", info='" + info + '\'' +
                ", status='" + status + '\'' +
                ", cardNo='" + cardNo + '\'' +
                '}';
    }
}
