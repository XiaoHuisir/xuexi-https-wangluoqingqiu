package com.example.ac.xuexi_https_wangluoqingqiu.utils;

public class ConstantUtils {

    public static  ConstantUtils constantUtils;
    private ConstantUtils(){}
    public static ConstantUtils getInstance(){

        if (constantUtils==null){
            synchronized (ConstantUtils.class){
                if (constantUtils==null){
                    constantUtils=new ConstantUtils();

                }
            }
        }
        return constantUtils;
    }
    public static final  int ONE_1=1001;

}
