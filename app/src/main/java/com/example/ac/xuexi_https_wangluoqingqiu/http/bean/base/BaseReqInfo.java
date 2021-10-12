package com.example.ac.xuexi_https_wangluoqingqiu.http.bean.base;

/**
 * Created by zhangfuxiao on 2017/8/21.
 */

public class BaseReqInfo {
    /**
     * MD5（所有参数值按文档顺序拼接+SALT）
     */
    private String sign;

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

}