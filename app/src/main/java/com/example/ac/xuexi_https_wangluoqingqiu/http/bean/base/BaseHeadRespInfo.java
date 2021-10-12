package com.example.ac.xuexi_https_wangluoqingqiu.http.bean.base;

/**
 * Created by zhangfuxiao on 2017/8/21.
 */

public class BaseHeadRespInfo<T> {
    /**
     * 状态字
     */
    private int status;
    /**
     * 状态描述信息
     */
    private String message;

    /**
     * 响应的数据
     */
    private T data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        String d="data:";
        if (data!=null){
             d=d+data.toString();
        }
        return "状态码："+status+",描述："+message+d;
    }
}
